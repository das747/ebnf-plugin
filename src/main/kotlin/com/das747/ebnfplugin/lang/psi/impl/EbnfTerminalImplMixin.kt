package com.das747.ebnfplugin.lang.psi.impl

import com.das747.ebnfplugin.ide.createPresentationFor
import com.das747.ebnfplugin.lang.psi.EbnfNonTerminal
import com.das747.ebnfplugin.lang.psi.EbnfTerminal
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation

abstract class EbnfTerminalImplMixin(node: ASTNode): EbnfTerminal, EbnfExprNodeImpl(node){
    override fun collectUsedNonTerminals(list: MutableList<EbnfNonTerminal>) {
        return
    }

    override val value: String
        get() = string.text

    override fun getPresentation(): ItemPresentation? {
        return createPresentationFor(this, value)
    }
}