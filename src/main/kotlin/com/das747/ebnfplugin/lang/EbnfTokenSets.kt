package com.das747.ebnfplugin.lang

import com.das747.ebnfplugin.lang.psi.EbnfTypes
import com.intellij.psi.tree.TokenSet

object EbnfTokenSets {
    val COMMENTS = TokenSet.create(EbnfTypes.COMMENT)
    val STRING_LITERALS = TokenSet.create(EbnfTypes.STRING)
}