package com.das747.ebnfplugin.ide.inspections

import com.das747.ebnfplugin.lang.hasSameElementType
import com.das747.ebnfplugin.lang.psi.*
import com.das747.ebnfplugin.lang.psi.tree.EbnfTreeNode
import com.intellij.codeInsight.intention.preview.IntentionPreviewInfo
import com.intellij.codeInspection.*
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.elementType

class EbnfRedundantNestingInspection : LocalInspectionTool() {
    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : EbnfVisitor() {
            private fun addProblem(element: EbnfExpr) {
                holder.registerProblem(
                    element,
                    "Redundant grouping",
                    ProblemHighlightType.WEAK_WARNING,
                    null,
                    RemoveRedundantNestingQuickFix()
                )
            }

            private fun visitModifier(o: EbnfTreeNode) {
                if (o.parent.hasSameElementType(o)) {
                    addProblem(o)
                }
            }

            override fun visitOptionalExpr(o: EbnfOptionalExpr) {
                super.visitOptionalExpr(o)
                visitModifier(o)
            }

            override fun visitMultipleExpr(o: EbnfMultipleExpr) {
                super.visitMultipleExpr(o)
                visitModifier(o)
            }

            override fun visitGroupExpr(o: EbnfGroupExpr) {
                super.visitGroupExpr(o)
                val children = o.getChildrenExpr()
                if (children.isNotEmpty() && (children[0] !is EbnfAlternativeExpr || o.parent !is EbnfConcatExpr)) {
                    addProblem(o)
                }
            }

        }
    }
}

private class RemoveRedundantNestingQuickFix : LocalQuickFix {
    override fun getFamilyName(): String = "Remove redundant nesting"

    override fun applyFix(project: Project, descriptor: ProblemDescriptor) {
        val target = descriptor.psiElement
        val child = liftChild(target) ?: return
        if (child.elementType in EbnfTokenSets.LIST_EXPRESSIONS && target.parent.hasSameElementType(
                child
            )
        ) {
            mergeChild(child)
        }
    }

    fun liftChild(target: PsiElement): EbnfExpr? {
        val child = PsiTreeUtil.getChildOfType(target, EbnfExpr::class.java) ?: return null
        return target.replace(child) as EbnfExpr
    }

    fun mergeChild(target: PsiElement) {
        val start = PsiTreeUtil.getChildOfType(target, EbnfExpr::class.java) ?: return
        val end = target.lastChild.let {
            if (it is EbnfExpr) it
            else PsiTreeUtil.getPrevSiblingOfType(it, EbnfExpr::class.java)
        } ?: return
        target.parent.addRangeBefore(start, end, target)
        target.delete()
    }
}