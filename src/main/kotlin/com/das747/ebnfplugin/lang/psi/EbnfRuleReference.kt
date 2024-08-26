package com.das747.ebnfplugin.lang.psi

import com.das747.ebnfplugin.lang.findNonTerminal
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementResolveResult
import com.intellij.psi.PsiPolyVariantReference
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.ResolveResult

class EbnfRuleReference(element: PsiElement, range: TextRange): PsiReferenceBase<PsiElement>(element, range), PsiPolyVariantReference {
    private val key = element.text.substring(range.startOffset, range.endOffset)

    override fun resolve(): PsiElement? {
        val resolveResults = multiResolve(false)
        if (resolveResults.size != 1) return null
        return resolveResults[0].element
    }

    override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {
        val project = myElement.project
        val definedRules = findNonTerminal(project, key)
        return definedRules.mapNotNull { it.parent }.map { PsiElementResolveResult(it) }.toTypedArray()
    }
}