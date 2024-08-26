package com.das747.ebnfplugin.lang.psi

import com.intellij.psi.util.PsiTreeUtil

object EbnfPsiImplUtil {
    fun getDefinedNonTerminal(rule: EbnfRule): EbnfNonTerminal? {
        return rule.node.findChildByType(EbnfTypes.ASSN)?.let {
            PsiTreeUtil.getPrevSiblingOfType(it.psi, EbnfNonTerminal::class.java)
        }
    }

    fun getDefinition(rule: EbnfRule): EbnfExpr? {
        return rule.node.findChildByType(EbnfTypes.ASSN)?.let {
            PsiTreeUtil.getNextSiblingOfType(it.psi, EbnfExpr::class.java)
        }
    }

    fun checkIfLhs(nonTerminal: EbnfNonTerminal): Boolean {
        return nonTerminal.parent?.let {
            it is EbnfRule && getDefinedNonTerminal(it) == nonTerminal
        } ?: false
    }

}