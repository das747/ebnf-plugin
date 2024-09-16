package com.das747.ebnfplugin.ide.inspections

import com.das747.ebnfplugin.lang.*
import com.intellij.codeInspection.*
import com.intellij.psi.PsiFile

class EbnfMultipleDeclarationsInspection : LocalInspectionTool() {

    override fun runForWholeFile(): Boolean = true

    override fun checkFile(
        file: PsiFile,
        manager: InspectionManager,
        isOnTheFly: Boolean
    ): Array<ProblemDescriptor>? {
        if (file !is EbnfFile) return null
        val problems = ProblemsHolder(manager, file, isOnTheFly)
        file.findAllRules().groupBy { it.getDefinedNonTerminal()?.value }
            .filter { (_, rules) -> rules.size > 1 }
            .forEach { (nonTerminal, rules) ->
                rules.forEach {
                    problems.registerProblem(
                        it,
                        "$nonTerminal has multiple declarations",
                        ProblemHighlightType.WARNING,
                        it.getChildRange(it.getDefinedNonTerminal())
                    )
                }
            }
        return problems.resultsArray
    }
}