package com.das747.ebnfplugin.ide

import com.das747.ebnfplugin.lang.psi.EbnfTokenSets
import com.intellij.codeInsight.editorActions.SimpleTokenSetQuoteHandler

class EbnfQuoteHandler : SimpleTokenSetQuoteHandler(EbnfTokenSets.STRING_LITERALS)
