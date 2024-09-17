package com.das747.ebnfplugin.ide.inspections

import com.das747.ebnfplugin.lang.*
import com.das747.ebnfplugin.lang.psi.EbnfElementFactory
import com.das747.ebnfplugin.lang.psi.EbnfRule
import com.intellij.codeInspection.*
import com.intellij.openapi.project.Project
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
                        it.getChildRange(it.getDefinedNonTerminal()),
                        CombineRuleDeclarationsQuickFix()
                    )
                }
            }
        return problems.resultsArray
    }
}

private class CombineRuleDeclarationsQuickFix: LocalQuickFix {
    override fun getFamilyName(): String = "Combine rule declarations"

    override fun applyFix(project: Project, descriptor: ProblemDescriptor) {
        val target = descriptor.psiElement
        if (target !is EbnfRule) return
        val rules = target.containingFile.findRulesByName(target.name)
        val newRule = EbnfElementFactory.createRule(project, target.name ?: "", rules.map { it.getDefinition()?.text ?: "" })
        target.replace(newRule)
        rules.filter { it != target }.forEach { it.delete() }
    }
}