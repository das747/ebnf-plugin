package com.das747.ebnfplugin.ide

import com.das747.ebnfplugin.lang.EbnfFile
import com.das747.ebnfplugin.lang.checkIfLhs
import com.das747.ebnfplugin.lang.findAllRules
import com.das747.ebnfplugin.lang.getDefinedNonTerminal
import com.das747.ebnfplugin.lang.psi.EbnfNonTerminal
import com.das747.ebnfplugin.lang.psi.EbnfRecursiveVisitor
import com.das747.ebnfplugin.lang.psi.EbnfRule
import com.das747.ebnfplugin.lang.psi.EbnfRuleReference
import com.intellij.codeHighlighting.HighlightDisplayLevel
import com.intellij.codeInspection.*
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiFile
import com.intellij.refactoring.suggested.startOffset

class EbnfUnusedDeclarationInspection : LocalInspectionTool() {

    override fun runForWholeFile(): Boolean = true

    override fun checkFile(
        file: PsiFile,
        manager: InspectionManager,
        isOnTheFly: Boolean
    ): Array<ProblemDescriptor>? {
        if (file !is EbnfFile) return null
        val rules = file.findAllRules()
        val problems = ProblemsHolder(manager, file, isOnTheFly)
        val usedRules = mutableSetOf<EbnfRule>()

        file.accept(object : EbnfRecursiveVisitor() {
            override fun visitNonTerminal(o: EbnfNonTerminal) {
                super.visitNonTerminal(o)
                if (o.checkIfLhs()) return
                val reference = o.reference
                if (reference !is EbnfRuleReference) return
                reference.multiResolve(false).forEach {
                    val result = it.element
                    if (result is EbnfRule) usedRules.add(result)
                }
            }
        })
        rules.forEach {
            if (it !in usedRules) {

                problems.registerProblem(
                    it,
                    "Unused rule",
                    ProblemHighlightType.LIKE_UNUSED_SYMBOL,
                    it.getLhsRange()
                )
            }
        }
        return problems.resultsArray
    }
}

private fun EbnfRule.getLhsRange(): TextRange? {
    return getDefinedNonTerminal()?.textRange?.shiftLeft(this.startOffset)
}