package com.das747.ebnfplugin.lang.psi.tree

import com.das747.ebnfplugin.lang.psi.EbnfExpr
import com.das747.ebnfplugin.lang.psi.EbnfNonTerminal

interface EbnfExprNode : EbnfExpr {
    fun collectUsedNonTerminals(list: MutableList<EbnfNonTerminal>)
}