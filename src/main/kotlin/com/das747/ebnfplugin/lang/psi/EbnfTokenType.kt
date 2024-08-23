package com.das747.ebnfplugin.lang.psi

import com.das747.ebnfplugin.lang.EbnfLanguage
import com.intellij.psi.tree.IElementType

class EbnfTokenType(debugName: String) : IElementType(debugName, EbnfLanguage) {
    override fun toString(): String = "EbnfTokenType.${super.toString()}"
}