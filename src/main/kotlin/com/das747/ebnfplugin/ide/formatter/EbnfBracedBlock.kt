package com.das747.ebnfplugin.ide.formatter

import com.das747.ebnfplugin.lang.psi.EbnfExpr
import com.intellij.formatting.*
import com.intellij.lang.ASTNode

class EbnfBracedBlock(
    node: ASTNode,
    attributes: EbnfBlockAttributes
) : EbnfDefaultBlock(node, attributes) {
    private val childWrap = Wrap.createWrap(WrapType.CHOP_DOWN_IF_LONG, false)
    private val braceAlignment = Alignment.createAlignment()

    override fun buildChild(childNode: ASTNode): Block? {
        val childIndent =
            if (childNode.psi is EbnfExpr) Indent.getNormalIndent() else Indent.getNoneIndent()
        val childAlignment =
            if (childNode.psi is EbnfExpr) Alignment.createAlignment() else braceAlignment
        return createEbnfBlock(
            childNode, EbnfBlockAttributes(
                childWrap,
                childAlignment,
                childIndent,
                spacingBuilder
            )
        )
    }

}