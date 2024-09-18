package com.das747.ebnfplugin.ide.inspections

import com.das747.ebnfplugin.lang.deleteVariant
import com.das747.ebnfplugin.lang.psi.*
import com.das747.ebnfplugin.lang.psi.tree.EbnfTreeNode
import com.intellij.codeInsight.intention.preview.IntentionPreviewInfo
import com.intellij.codeInspection.*
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.SmartPointerManager
import com.intellij.psi.util.elementType

class EbnfAlternativePushDownInspection : LocalInspectionTool() {
    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : EbnfVisitor() {
            private inline fun <reified T : EbnfTreeNode> reportSameModifiers(
                children: List<EbnfExpr>
            ) {
                val modifiers = children.filterIsInstance<T>()
                if (modifiers.size > 1) {
                    val fix = PushDownAlternative(holder.project, modifiers)
                    modifiers.forEach {
                        holder.registerProblem(
                            it,
                            "Alternative can be pushed down into ${it.elementType}",
                            ProblemHighlightType.WEAK_WARNING,
                            null,
                            fix
                        )
                    }
                }
            }

            override fun visitAlternativeExpr(o: EbnfAlternativeExpr) {
                val children = o.getChildrenExpr()
                reportSameModifiers<EbnfMultipleExpr>(children)
                reportSameModifiers<EbnfOptionalExpr>(children)
            }
        }
    }
}

private class PushDownAlternative(project: Project, variants: List<EbnfTreeNode>) :
    LocalQuickFix {
    val variantsPointers =
        variants.map {
            SmartPointerManager.getInstance(project).createSmartPsiElementPointer(it)
        }

    override fun getFamilyName(): String = "Push down alternative"

    override fun applyFix(project: Project, descriptor: ProblemDescriptor) {
        val target = descriptor.psiElement
        val alternative = target.parent
        if (alternative !is EbnfAlternativeExpr) return
        val variants =
            variantsPointers.mapNotNull { it.element?.getChildrenExpr()?.getOrNull(0)?.text }
        val newExpr =
            EbnfElementFactory.createExpression(project, target.elementType!!, variants)
        alternative.addBefore(newExpr, target)
        variantsPointers.mapNotNull { it.element }.forEach { alternative.deleteVariant(it) }
    }

    override fun generatePreview(
        project: Project,
        previewDescriptor: ProblemDescriptor
    ): IntentionPreviewInfo {
        return IntentionPreviewInfo.EMPTY
    }

}