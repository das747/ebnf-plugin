package com.das747.ebnfplugin.ide.inspections

import com.das747.ebnfplugin.lang.getChildRange
import com.das747.ebnfplugin.lang.psi.*
import com.das747.ebnfplugin.lang.psi.tree.EbnfTreeNode
import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.util.elementType

class EbnfRedundantNestingInspection: LocalInspectionTool() {
    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object: EbnfVisitor() {
            fun visitEbnfTreeNode(expr: EbnfTreeNode) {
                findNestedExpressions(expr).forEach {
                    holder.registerProblem(
                        expr,
                        "Redundant nesting of ${it.elementType}",
                        ProblemHighlightType.WEAK_WARNING,
                        expr.getChildRange(it)
                    )
                }
            }

            override fun visitAlternativeExpr(o: EbnfAlternativeExpr) {
                super.visitAlternativeExpr(o)
                visitEbnfTreeNode(o)
            }

            override fun visitConcatExpr(o: EbnfConcatExpr) {
                super.visitConcatExpr(o)
                visitEbnfTreeNode(o)
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



fun findNestedExpressions(expr: EbnfTreeNode): List<EbnfExpr> {
    return expr.getChildrenExpr().filter { it.elementType == expr.elementType }
}