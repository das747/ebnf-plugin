package com.das747.ebnfplugin.lang.psi

import com.das747.ebnfplugin.lang.psi.EbnfTypes.*
import com.intellij.psi.tree.TokenSet

object EbnfTokenSets {
    val COMMENTS = TokenSet.create(COMMENT)
    val STRING_LITERALS = TokenSet.create(STRING)
    val BRACKETS = TokenSet.create(
        SQR_L,
        SQR_R,
        CURL_L,
        CURL_R,
        BRACE_L,
        BRACE_R
    )
    val IDENTIFIERS = TokenSet.create(ID)
    val ATOM_EXPRESSIONS = TokenSet.create(
        NON_TERMINAL,
        TERMINAL,
        CONCAT_EXPR,
        ALTERNATIVE_EXPR,
        MULTIPLE_EXPR,
        OPTIONAL_EXPR,
    )

    val LIST_EXPRESSIONS = TokenSet.create(ALTERNATIVE_EXPR, CONCAT_EXPR)
    val BRACED_EXPRESSIONS = TokenSet.create(OPTIONAL_EXPR, MULTIPLE_EXPR, GROUP_EXPR)
}