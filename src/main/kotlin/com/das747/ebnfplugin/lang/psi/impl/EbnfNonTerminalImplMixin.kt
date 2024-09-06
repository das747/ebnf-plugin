package com.das747.ebnfplugin.lang.psi.impl

import com.das747.ebnfplugin.ide.createPresentationFor
import com.das747.ebnfplugin.lang.psi.EbnfNonTerminal
import com.das747.ebnfplugin.lang.psi.EbnfRuleReference
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiReference

abstract class EbnfNonTerminalImplMixin(node: ASTNode) : EbnfNonTerminal, EbnfExprNodeImpl(node) {
    override fun getReference(): PsiReference? {
        return EbnfRuleReference(this)
    }

    override fun collectUsedNonTerminals(list: MutableList<EbnfNonTerminal>) {
        list.add(this)
    }

    override val value: String
        get() = id.text

    override fun getPresentation(): ItemPresentation? {
        return createPresentationFor(this, value, true)
    }
}