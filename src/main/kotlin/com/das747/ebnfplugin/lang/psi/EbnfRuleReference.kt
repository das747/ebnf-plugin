package com.das747.ebnfplugin.lang.psi

import com.das747.ebnfplugin.lang.EbnfIcons
import com.das747.ebnfplugin.lang.findDefinedNonTerminals
import com.das747.ebnfplugin.lang.findNonTerminal
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementResolveResult
import com.intellij.psi.PsiPolyVariantReference
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.ResolveResult

class EbnfRuleReference(element: PsiElement) :
    PsiReferenceBase<PsiElement>(element), PsiPolyVariantReference {
    private val key = element.text

    override fun resolve(): PsiElement? {
        val resolveResults = multiResolve(false)
        if (resolveResults.size != 1) return null
        return resolveResults[0].element
    }

    override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {
        val project = myElement.project
        val definedRules = findNonTerminal(project, key)
        return definedRules.mapNotNull { it.parent }.map { PsiElementResolveResult(it) }
            .toTypedArray()
    }

    override fun getVariants(): Array<Any> {
        return findDefinedNonTerminals(myElement.project).map {
            LookupElementBuilder.create(it.parent as EbnfRule).withIcon(EbnfIcons.FILE)
                .withTypeText(it.containingFile.name)
        }.toTypedArray()
    }
}