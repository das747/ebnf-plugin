package com.das747.ebnfplugin.lang.psi

import com.intellij.psi.tree.TokenSet

object EbnfTokenSets {
    val COMMENTS = TokenSet.create(EbnfTypes.COMMENT)
    val STRING_LITERALS = TokenSet.create(EbnfTypes.STRING)
    val BRACKETS = TokenSet.create(
        EbnfTypes.SQR_L,
        EbnfTypes.SQR_R,
        EbnfTypes.CURL_L,
        EbnfTypes.CURL_R,
        EbnfTypes.BRACE_L,
        EbnfTypes.BRACE_R
    )
}