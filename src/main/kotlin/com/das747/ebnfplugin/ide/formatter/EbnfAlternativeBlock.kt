package com.das747.ebnfplugin.ide.formatter

import com.das747.ebnfplugin.lang.psi.EbnfExpr
import com.intellij.formatting.*
import com.intellij.lang.ASTNode

class EbnfAlternativeBlock(node: ASTNode, attributes: EbnfBlockAttributes) :
    EbnfDefaultBlock(node, attributes) {
    private val nonExprChildWrap = Wrap.createWrap(WrapType.CHOP_DOWN_IF_LONG, true)
    private val exprChildWrap = Wrap.createChildWrap(nonExprChildWrap, WrapType.NONE, false)
    private val exprAlignment = Alignment.createAlignment(true)


    override fun buildChild(childNode: ASTNode): Block? {
        val childWrap = if (childNode.psi is EbnfExpr) exprChildWrap else nonExprChildWrap
//        val childAlignment = if (childNode.psi is EbnfExpr) exprAlignment else null

        return createEbnfBlock(
            childNode,
            EbnfBlockAttributes(
                childWrap,
                exprAlignment,
                Indent.getNoneIndent(),
                spacingBuilder
            )
        )
    }
}