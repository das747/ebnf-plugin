package com.das747.ebnfplugin.ide.inspections

import com.das747.ebnfplugin.lang.getChildRange
import com.das747.ebnfplugin.lang.psi.EbnfAlternativeExpr
import com.das747.ebnfplugin.lang.psi.EbnfExpr
import com.das747.ebnfplugin.lang.psi.EbnfMultipleExpr
import com.das747.ebnfplugin.lang.psi.EbnfOptionalExpr
import com.das747.ebnfplugin.lang.psi.EbnfVisitor
import com.das747.ebnfplugin.lang.psi.tree.EbnfTreeNode
import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.util.elementType

class EbnfAlternativePushDownInspection : LocalInspectionTool() {
    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : EbnfVisitor() {
            private inline fun <reified T: EbnfTreeNode> reportSameModifiers(o: EbnfAlternativeExpr, children: List<EbnfExpr>) {
                children.filterIsInstance<T>().let {
                    if (it.size > 1) it.forEach {
                        holder.registerProblem(
                            o,
                            "Alternative can be pushed down into ${it.elementType}",
                            ProblemHighlightType.WEAK_WARNING,
                            o.getChildRange(it)
                        )
                    }
                }
            }

            override fun visitAlternativeExpr(o: EbnfAlternativeExpr) {
                val children = o.getChildrenExpr()
                reportSameModifiers<EbnfMultipleExpr>(o, children)
                reportSameModifiers<EbnfOptionalExpr>(o, children)
            }
        }
    }
}