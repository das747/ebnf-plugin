package com.das747.ebnfplugin.lang.psi.impl

import com.das747.ebnfplugin.ide.createPresentationFor
import com.das747.ebnfplugin.lang.psi.EbnfAlternativeExpr
import com.das747.ebnfplugin.lang.psi.EbnfConcatExpr
import com.das747.ebnfplugin.lang.psi.EbnfMultipleExpr
import com.das747.ebnfplugin.lang.psi.EbnfNonTerminal
import com.das747.ebnfplugin.lang.psi.EbnfOptionalExpr
import com.das747.ebnfplugin.lang.psi.tree.EbnfExprNode
import com.das747.ebnfplugin.lang.psi.tree.EbnfTreeNode
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.util.PsiTreeUtil

abstract class EbnfTreeNodeImplMixin(node: ASTNode) : EbnfTreeNode, EbnfExprNodeImpl(node) {
    override fun getChildrenExpr(): List<EbnfExprNode> {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, EbnfExprNode::class.java)
    }

    override fun collectUsedNonTerminals(list: MutableList<EbnfNonTerminal>) {
        getChildrenExpr().forEach { it.collectUsedNonTerminals(list) }
    }

    override fun getPresentation(): ItemPresentation? {
        val text = when (this) {
            is EbnfConcatExpr -> "concatenation of "
            is EbnfMultipleExpr -> "zero or more of"
            is EbnfAlternativeExpr -> "any of"
            is EbnfOptionalExpr -> "optional"
            else -> null
        }
        return createPresentationFor(this, text)
    }
}