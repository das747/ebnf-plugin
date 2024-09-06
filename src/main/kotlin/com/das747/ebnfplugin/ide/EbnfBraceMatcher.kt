package com.das747.ebnfplugin.ide

import com.das747.ebnfplugin.lang.psi.EbnfTypes.*
import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType

private val PAIRS = arrayOf(
    BracePair(BRACE_L, BRACE_R, false),
    BracePair(SQR_L, SQR_R, false),
    BracePair(CURL_L, CURL_R, false)
)

class EbnfBraceMatcher : PairedBraceMatcher {
    override fun getPairs(): Array<BracePair> = PAIRS

    override fun isPairedBracesAllowedBeforeType(
        lbraceType: IElementType,
        contextType: IElementType?
    ): Boolean {
        return true
    }

    override fun getCodeConstructStart(file: PsiFile?, openingBraceOffset: Int): Int {
        return openingBraceOffset
    }
}