package com.das747.ebnfplugin.ide.inspections

import com.das747.ebnfplugin.lang.checkExpressionEquality
import com.das747.ebnfplugin.lang.psi.EbnfAlternativeExpr
import com.das747.ebnfplugin.lang.psi.EbnfExpr
import com.das747.ebnfplugin.lang.psi.EbnfVisitor
import com.intellij.codeInsight.intention.preview.IntentionPreviewInfo
import com.intellij.codeInspection.*
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.SmartPointerManager
import com.intellij.psi.util.PsiTreeUtil

class EbnfEqualAlternativeVariantsInspection : LocalInspectionTool() {
    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : EbnfVisitor() {
            override fun visitAlternativeExpr(o: EbnfAlternativeExpr) {
                super.visitAlternativeExpr(o)
                val variants = o.getChildrenExpr()
                val equalityClasses = mutableListOf<MutableList<EbnfExpr>>()
                variants.forEach outer@{ variant ->
                    equalityClasses.forEach { list ->
                        if (list.isNotEmpty() && checkExpressionEquality(list.first(), variant)) {
                            list.add(variant)
                            return@outer
                        }
                    }
                    equalityClasses.add(mutableListOf(variant))
                }
                equalityClasses.filter { it.size > 1 }.forEach { list ->
                    val fix = SafeDeleteEquivalentAlternativesQuickFix(holder.project, list)
                    list.forEach {
                        holder.registerProblem(
                            it,
                            "Duplicated alternative variant",
                            ProblemHighlightType.WARNING,
                            fix
                        )
                    }
                }
            }
        }
    }
}

private class SafeDeleteEquivalentAlternativesQuickFix(project: Project, variants: List<EbnfExpr>) :
    LocalQuickFix {
    private val variantsPointers = variants.map {
        SmartPointerManager.getInstance(project).createSmartPsiElementPointer(it)
    }

    override fun getFamilyName(): String = "Safe delete"

    override fun getName(): String = "Safe delete equal variants"

    override fun applyFix(project: Project, descriptor: ProblemDescriptor) {
        val alternative = descriptor.psiElement.parent
        if (alternative !is EbnfAlternativeExpr) return
        variantsPointers.mapNotNull { it.element }.drop(1).forEach { variant ->
            PsiTreeUtil.getPrevSiblingOfType(variant, EbnfExpr::class.java)?.let { prev ->
                alternative.deleteChildRange(prev.nextSibling, variant)
            } ?: variant.delete()
        }
    }

    override fun generatePreview(
        project: Project,
        previewDescriptor: ProblemDescriptor
    ): IntentionPreviewInfo {
        return IntentionPreviewInfo.EMPTY
    }
}
