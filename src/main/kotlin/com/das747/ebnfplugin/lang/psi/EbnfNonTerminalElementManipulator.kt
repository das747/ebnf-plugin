package com.das747.ebnfplugin.lang.psi

import com.intellij.openapi.util.TextRange
import com.intellij.psi.AbstractElementManipulator

class EbnfNonTerminalElementManipulator : AbstractElementManipulator<EbnfNonTerminal>() {
    override fun handleContentChange(
        element: EbnfNonTerminal,
        range: TextRange,
        newContent: String?
    ): EbnfNonTerminal? {
        if (newContent == null) return null
        val newElement = EbnfElementFactory.createNonTerminal(
            element.project,
            range.replace(element.text, newContent)
        )
        return element.replace(newElement) as EbnfNonTerminal
    }
}