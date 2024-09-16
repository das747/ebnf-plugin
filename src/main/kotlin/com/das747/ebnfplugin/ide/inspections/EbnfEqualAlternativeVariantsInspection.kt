package com.das747.ebnfplugin.ide.inspections

import com.das747.ebnfplugin.lang.checkExpressionEquality
import com.das747.ebnfplugin.lang.getChildRange
import com.das747.ebnfplugin.lang.psi.EbnfAlternativeExpr
import com.das747.ebnfplugin.lang.psi.EbnfExpr
import com.das747.ebnfplugin.lang.psi.EbnfVisitor
import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElementVisitor

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
                    list.forEach {
                        holder.registerProblem(
                            o,
                            "Duplicated alternative variant",
                            ProblemHighlightType.WARNING,
                            o.getChildRange(it)
                        )
                    }
                }
            }
        }
    }
}