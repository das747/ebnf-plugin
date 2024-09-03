package com.das747.ebnfplugin.ide.formatter

import com.das747.ebnfplugin.lang.psi.EbnfExpr
import com.das747.ebnfplugin.lang.psi.EbnfTokenSets
import com.das747.ebnfplugin.lang.psi.EbnfTypes
import com.intellij.formatting.*
import com.intellij.lang.ASTNode
import com.intellij.psi.TokenType
import com.intellij.psi.formatter.common.AbstractBlock
import com.intellij.psi.util.elementType

class EbnfBlock(
    node: ASTNode,
    wrap: Wrap,
    alignment: Alignment,
    private val indent: Indent,
    private val spacingBuilder: SpacingBuilder
) : AbstractBlock(node, wrap, alignment) {

    private val exprChildWrap: Wrap
    private val nonExprChildWrap: Wrap
    private val childIndent: Indent
    private var childAlignment: Alignment? = null

    init {
        when (node.psi.elementType) {
            EbnfTypes.CONCAT_EXPR -> {
                exprChildWrap = Wrap.createWrap(WrapType.CHOP_DOWN_IF_LONG, false)
                nonExprChildWrap = Wrap.createWrap(WrapType.NONE, false)
                childIndent = Indent.getNoneIndent()
                childAlignment =  Alignment.createAlignment(true)
            }

            EbnfTypes.ALTERNATIVE_EXPR -> {
                nonExprChildWrap = Wrap.createWrap(WrapType.CHOP_DOWN_IF_LONG, true)
                exprChildWrap = Wrap.createChildWrap(nonExprChildWrap, WrapType.NONE, false)
                childIndent = Indent.getNoneIndent()
                childAlignment =  Alignment.createAlignment(true)
            }

            in EbnfTokenSets.MODIFIER_EXPRESSIONS -> {
                exprChildWrap = Wrap.createWrap(WrapType.CHOP_DOWN_IF_LONG, false)
                nonExprChildWrap = exprChildWrap
                childIndent = Indent.getNormalIndent()
            }

            else -> {
                exprChildWrap = Wrap.createWrap(WrapType.NONE, false)
                nonExprChildWrap = exprChildWrap
                childIndent = Indent.getNoneIndent()
            }
        }
    }

    override fun getSpacing(child1: Block?, child2: Block): Spacing? {
        return spacingBuilder.getSpacing(this, child1, child2)
    }

    override fun isLeaf(): Boolean = node.firstChildNode == null

    override fun getIndent(): Indent? = indent

    override fun buildChildren(): MutableList<Block> {
        return node.getChildren(null).filter { it.elementType != TokenType.WHITE_SPACE }
            .map { buildChild(it) }.toMutableList()
    }

    private fun buildChild(childNode: ASTNode): Block {
        return if (childNode.psi is EbnfExpr) {
            EbnfBlock(
                childNode,
                exprChildWrap,
                childAlignment ?: Alignment.createAlignment(),
                childIndent,
                spacingBuilder
            )
        } else {
            EbnfBlock(
                childNode,
                nonExprChildWrap,
                Alignment.createAlignment(),
                Indent.getNoneIndent(),
                spacingBuilder
            )
        }
    }
}