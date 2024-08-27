package com.das747.ebnfplugin.lang.psi.impl

import com.das747.ebnfplugin.lang.psi.EbnfNonTerminal
import com.das747.ebnfplugin.lang.psi.EbnfRuleReference
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiReference

abstract class EbnfNonTerminalImplMixin(node: ASTNode): EbnfNonTerminal, EbnfExprImpl(node) {
    override fun getReference(): PsiReference? {
        return EbnfRuleReference(this)
    }
}