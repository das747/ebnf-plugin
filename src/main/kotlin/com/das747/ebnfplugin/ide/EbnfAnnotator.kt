package com.das747.ebnfplugin.ide

import com.das747.ebnfplugin.ide.intentions.EbnfCreateDefinitionIntention
import com.das747.ebnfplugin.lang.checkIfLhs
import com.das747.ebnfplugin.lang.findRulesByName
import com.das747.ebnfplugin.lang.psi.EbnfNonTerminal
import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.psi.PsiElement

class EbnfAnnotator : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element !is EbnfNonTerminal) {
            return
        }

        if (element.checkIfLhs()) {
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                .range(element.textRange)
                .textAttributes(DefaultLanguageHighlighterColors.FUNCTION_DECLARATION)
                .create()
            return
        }

        val definitions = element.containingFile.findRulesByName(element.text)
        if (definitions.isEmpty()) {
            holder.newAnnotation(HighlightSeverity.ERROR, "Undefined non-terminal")
                .range(element.textRange)
                .highlightType(ProblemHighlightType.LIKE_UNKNOWN_SYMBOL)
                .withFix(EbnfCreateDefinitionIntention(element.value))
                .create()
        } else {
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                .range(element.textRange)
                .textAttributes(DefaultLanguageHighlighterColors.KEYWORD)
                .create()
        }
    }
}