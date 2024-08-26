package com.das747.ebnfplugin.lang.psi.impl

import com.das747.ebnfplugin.lang.psi.EbnfNonTerminal
import com.das747.ebnfplugin.lang.psi.EbnfRuleReference
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiReference

abstract class EbnfNonTerminalImplMixin(node: ASTNode): EbnfNonTerminal, EbnfExprImpl(node) {
    override fun getReference(): PsiReference? {
        return EbnfRuleReference(this, TextRange.create(0, this.text.length))
    }
}