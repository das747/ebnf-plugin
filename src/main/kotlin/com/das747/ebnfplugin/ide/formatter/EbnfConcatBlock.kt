package com.das747.ebnfplugin.ide.formatter

import com.das747.ebnfplugin.lang.psi.EbnfExpr
import com.intellij.formatting.*
import com.intellij.lang.ASTNode

class EbnfConcatBlock(node: ASTNode, attributes: EbnfBlockAttributes) :
    EbnfDefaultBlock(node, attributes) {
    private var childWrap = Wrap.createWrap(WrapType.CHOP_DOWN_IF_LONG, false)
    private val childAlignment = Alignment.createAlignment(true)
    private var firstExprChild = true

    override fun buildChild(childNode: ASTNode): Block? {
        return if (childNode.psi is EbnfExpr) {
            var wrap = childWrap
            if (firstExprChild) {
                firstExprChild = false
                wrap = Wrap.createWrap(WrapType.NONE, false)
            }
            createEbnfBlock(
                childNode, EbnfBlockAttributes(
                    wrap,
                    childAlignment,
                    Indent.getNoneIndent(),
                    spacingBuilder
                )
            )
        } else null
    }
}