package com.das747.ebnfplugin.lang

import com.das747.ebnfplugin.lang.psi.EbnfNonTerminal
import com.das747.ebnfplugin.lang.psi.EbnfRule
import com.das747.ebnfplugin.lang.psi.EbnfTerminal
import com.das747.ebnfplugin.lang.psi.tree.EbnfExprNode
import com.intellij.icons.AllIcons
import com.intellij.ide.IconProvider
import com.intellij.psi.PsiElement
import javax.swing.Icon

class EbnfIconProvider : IconProvider() {
    override fun getIcon(element: PsiElement, flags: Int): Icon? {
        return when (element) {
            is EbnfRule -> EbnfIcons.RULE
            is EbnfNonTerminal -> AllIcons.Nodes.Variable
            is EbnfTerminal -> EbnfIcons.TERMINAL
            is EbnfExprNode -> EbnfIcons.EXPR
            else -> null
        }
    }
}