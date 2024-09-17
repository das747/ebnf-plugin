package com.das747.ebnfplugin.ide.inspections

import com.das747.ebnfplugin.lang.getChildRange
import com.das747.ebnfplugin.lang.hasSameElementType
import com.das747.ebnfplugin.lang.psi.*
import com.das747.ebnfplugin.lang.psi.tree.EbnfTreeNode
import com.intellij.codeInsight.intention.preview.IntentionPreviewInfo
import com.intellij.codeInspection.*
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.PsiExpression
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.elementType

class EbnfRedundantNestingInspection : LocalInspectionTool() {
    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : EbnfVisitor() {
            private fun addProblem(element: EbnfExpr) {
                holder.registerProblem(
                    element,
                    "Redundant nesting of ${element.elementType}",
                    ProblemHighlightType.WEAK_WARNING,
                    null,
                    RemoveRedundantNestingQuickFix()
                )
            }

            fun visitEbnfTreeNode(expr: EbnfTreeNode) {
                findNestedExpressions(expr).forEach { addProblem(it) }
            }

            override fun visitAlternativeExpr(o: EbnfAlternativeExpr) {
                super.visitAlternativeExpr(o)
                visitEbnfTreeNode(o)
            }

            override fun visitConcatExpr(o: EbnfConcatExpr) {
                super.visitConcatExpr(o)
                o.getChildrenExpr().filterIsInstance<EbnfGroupExpr>().filter {
                    it.getChildrenExpr().let { it.isNotEmpty() && it[0] !is EbnfAlternativeExpr }
                }.forEach { addProblem(it) }
            }

            override fun visitOptionalExpr(o: EbnfOptionalExpr) {
                super.visitOptionalExpr(o)
                visitEbnfTreeNode(o)
            }

            override fun visitMultipleExpr(o: EbnfMultipleExpr) {
                super.visitMultipleExpr(o)
                visitEbnfTreeNode(o)
            }

        }
    }
}


private fun findNestedExpressions(expr: EbnfTreeNode): List<EbnfExpr> {
    return expr.getChildrenExpr().filter { it.hasSameElementType(expr) || it is EbnfGroupExpr }
}


private class RemoveRedundantNestingQuickFix : LocalQuickFix {
    override fun getFamilyName(): String = "Remove redundant nesting"

    override fun applyFix(project: Project, descriptor: ProblemDescriptor) {
        val target = descriptor.psiElement
        val child = liftChild(target) ?: return
        if (target.elementType in EbnfTokenSets.LIST_EXPRESSIONS &&
            target.parent.hasSameElementType(child)
        ) {
            mergeChild(child)
        }
    }

    fun liftChild(target: PsiElement): EbnfExpr? {
        val child = PsiTreeUtil.getChildOfType(target, EbnfExpr::class.java) ?: return null
        val targetNode = target.node
        targetNode.treeParent.replaceChild(targetNode, child.node)
        return child
    }

    fun mergeChild(target: PsiElement) {
        val targetNode = target.node
        val start = PsiTreeUtil.getChildOfType(target, EbnfExpr::class.java)?.node ?: return
        val end = target.lastChild.let { if (it !is EbnfExpr) it.node else null }
        targetNode.treeParent.addChildren(start, end, targetNode)
        targetNode.treeParent.removeChild(targetNode)
    }

    override fun generatePreview(
        project: Project,
        previewDescriptor: ProblemDescriptor
    ): IntentionPreviewInfo {
        return IntentionPreviewInfo.EMPTY
    }

}