package com.das747.ebnfplugin.ide.formatter

import com.das747.ebnfplugin.lang.psi.EbnfTokenSets
import com.das747.ebnfplugin.lang.psi.EbnfTypes
import com.intellij.formatting.*
import com.intellij.lang.ASTNode
import com.intellij.psi.TokenType
import com.intellij.psi.formatter.common.AbstractBlock
import com.intellij.psi.util.elementType

fun createEbnfBlock(
    node: ASTNode,
    attributes: EbnfBlockAttributes
): Block {
    return when (node.psi.elementType) {
        in EbnfTokenSets.MODIFIER_EXPRESSIONS -> EbnfBracedBlock(node, attributes)
        EbnfTypes.ALTERNATIVE_EXPR -> EbnfAlternativeBlock(node, attributes)
        EbnfTypes.CONCAT_EXPR -> EbnfConcatBlock(node, attributes)
        else -> EbnfDefaultBlock(node, attributes)
    }
}

data class EbnfBlockAttributes(
    val wrap: Wrap?,
    val alignment: Alignment?,
    val indent: Indent?,
    val spacingBuilder: SpacingBuilder
)

open class EbnfDefaultBlock(
    node: ASTNode,
    attributes: EbnfBlockAttributes
) : AbstractBlock(node, attributes.wrap, attributes.alignment) {
    private val indent = attributes.indent
    protected val spacingBuilder = attributes.spacingBuilder

    init {
//        when (node.psi.elementType) {
//            EbnfTypes.CONCAT_EXPR -> {
//                exprChildWrap = Wrap.createWrap(WrapType.CHOP_DOWN_IF_LONG, false)
//                nonExprChildWrap = Wrap.createWrap(WrapType.NONE, false)
//                childIndent = Indent.getNoneIndent()
//                childAlignment =  Alignment.createAlignment(true)
//            }
//
//            EbnfTypes.ALTERNATIVE_EXPR -> {
//                nonExprChildWrap = Wrap.createWrap(WrapType.CHOP_DOWN_IF_LONG, true)
//                exprChildWrap = Wrap.createChildWrap(nonExprChildWrap, WrapType.NONE, false)
//                childIndent = Indent.getNoneIndent()
//                childAlignment =  Alignment.createAlignment(true)
//            }
//
//            in EbnfTokenSets.MODIFIER_EXPRESSIONS -> {
//                exprChildWrap = Wrap.createWrap(WrapType.CHOP_DOWN_IF_LONG, false)
//                nonExprChildWrap = exprChildWrap
//                childIndent = Indent.getNormalIndent()
//            }
//
//            else -> {
//                exprChildWrap = Wrap.createWrap(WrapType.NONE, false)
//                nonExprChildWrap = exprChildWrap
//                childIndent = Indent.getNoneIndent()
//            }
//        }
    }

    override fun getSpacing(child1: Block?, child2: Block): Spacing? {
        return spacingBuilder.getSpacing(this, child1, child2)
    }

    override fun isLeaf(): Boolean = node.firstChildNode == null

    override fun getIndent(): Indent? = indent

    override fun buildChildren(): MutableList<Block> {
        return node.getChildren(null).filter { it.elementType != TokenType.WHITE_SPACE }
            .mapNotNull { buildChild(it) }.toMutableList()
    }

    open fun buildChild(childNode: ASTNode): Block? {
        return createEbnfBlock(
            childNode, EbnfBlockAttributes(
                Wrap.createWrap(WrapType.NONE, false),
                Alignment.createAlignment(),
                Indent.getNoneIndent(),
                spacingBuilder
            )
        )
    }

    protected open val incomplete = false

    override fun isIncomplete(): Boolean = incomplete

}