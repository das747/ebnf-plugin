package com.das747.ebnfplugin.lang

import com.das747.ebnfplugin.lang.psi.EbnfTokenSets
import com.das747.ebnfplugin.lang.psi.EbnfTypes
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

val COMMENT = createTextAttributesKey("EBNF_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
val BRACKET = createTextAttributesKey("EBNF_BRACKET", DefaultLanguageHighlighterColors.PARENTHESES)
val ALTERNATIVE =
    createTextAttributesKey("EBNF_ALTERNATIVE", DefaultLanguageHighlighterColors.OPERATION_SIGN)
val NON_TERMINAL =
    createTextAttributesKey("EBNF_NON_TERMINAL", DefaultLanguageHighlighterColors.IDENTIFIER)
val TERMINAL = createTextAttributesKey("EBNF_TERMINAL", DefaultLanguageHighlighterColors.STRING)
val BAD_CHARACTER = createTextAttributesKey("EBNF_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)
val SEMICOLON = createTextAttributesKey("EBNF_SEMICOLON", DefaultLanguageHighlighterColors.SEMICOLON)

val COMMENT_KEYS = arrayOf(COMMENT)
val BRACKET_KEYS = arrayOf(BRACKET)
val ALTERNATIVE_KEYS = arrayOf(ALTERNATIVE)
val NON_TERMINAL_KEYS = arrayOf(NON_TERMINAL)
val TERMINAL_KEYS = arrayOf(TERMINAL)
val BAD_CHARACTER_KEYS = arrayOf(BAD_CHARACTER)
val SEMICOLON_KEYS = arrayOf(SEMICOLON)
val EMPTY_KEYS = emptyArray<TextAttributesKey>()

class EbnfSyntaxHighlighter : SyntaxHighlighter {
    override fun getHighlightingLexer(): Lexer = EbnfLexerAdapter()

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> {
        if (EbnfTokenSets.BRACKETS.contains(tokenType)) return BRACKET_KEYS
        return when (tokenType) {
            EbnfTypes.COMMENT -> COMMENT_KEYS
            EbnfTypes.OR -> ALTERNATIVE_KEYS
            EbnfTypes.ID -> NON_TERMINAL_KEYS
            EbnfTypes.STRING -> TERMINAL_KEYS
            EbnfTypes.SEMI -> SEMICOLON_KEYS
            TokenType.BAD_CHARACTER -> BAD_CHARACTER_KEYS
            else -> EMPTY_KEYS
        }
    }
}