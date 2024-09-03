package com.das747.ebnfplugin.ide.formatter

import com.das747.ebnfplugin.lang.EbnfLanguage
import com.das747.ebnfplugin.lang.psi.EbnfTokenSets
import com.das747.ebnfplugin.lang.psi.EbnfTypes.*
import com.intellij.formatting.*
import com.intellij.psi.codeStyle.CodeStyleSettings

private fun createSpacingBuilder(settings: CodeStyleSettings): SpacingBuilder {
    val commonSettings = settings.getCommonSettings(EbnfLanguage)
    val assignmentSpacing = if (commonSettings.SPACE_AROUND_ASSIGNMENT_OPERATORS) 1 else 0

    return SpacingBuilder(settings, EbnfLanguage)
        .around(ASSN).spacing(assignmentSpacing, assignmentSpacing, 0, false, 0)
        .withinPair(BRACE_L, BRACE_R).spaceIf(commonSettings.SPACE_WITHIN_PARENTHESES)
        .withinPair(CURL_L, CURL_R).spaceIf(commonSettings.SPACE_WITHIN_BRACES)
        .withinPair(SQR_L, SQR_R).spaceIf(commonSettings.SPACE_WITHIN_BRACKETS)
        .before(SEMI).spaceIf(commonSettings.SPACE_BEFORE_SEMICOLON)
        .after(SEMI).none()
        .around(OR).spaceIf(commonSettings.SPACE_AROUND_BITWISE_OPERATORS)
        .between(EbnfTokenSets.ATOM_EXPRESSIONS, EbnfTokenSets.ATOM_EXPRESSIONS).spaces(1)
        .between(EbnfTokenSets.ATOM_EXPRESSIONS, BRACE_L).spaces(1)
        .between(BRACE_R, EbnfTokenSets.ATOM_EXPRESSIONS).spaces(1)
        .between(RULE, RULE).lineBreakInCode()
        .before(RULE).none()
}

class EbnfFormattingModelBuilder : FormattingModelBuilder {
    override fun createModel(formattingContext: FormattingContext): FormattingModel {
        val settings = formattingContext.codeStyleSettings
        settings.getCommonSettings(EbnfLanguage)
        return FormattingModelProvider.createFormattingModelForPsiFile(
            formattingContext.containingFile,
            EbnfBlock(
                formattingContext.node,
                Wrap.createWrap(WrapType.NONE, false),
                Alignment.createAlignment(),
                Indent.getNoneIndent(),
                createSpacingBuilder(settings)
            ),
            settings
        )
    }
}