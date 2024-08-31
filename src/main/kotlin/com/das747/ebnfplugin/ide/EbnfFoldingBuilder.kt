package com.das747.ebnfplugin.ide

import com.das747.ebnfplugin.lang.findRulesByName
import com.das747.ebnfplugin.lang.psi.EbnfNonTerminal
import com.das747.ebnfplugin.lang.psi.EbnfPsiImplUtil
import com.das747.ebnfplugin.lang.psi.EbnfRecursiveVisitor
import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingBuilderEx
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.editor.FoldingGroup
import com.intellij.openapi.util.text.StringUtil
import com.intellij.psi.PsiElement

class EbnfFoldingBuilder : FoldingBuilderEx() {
    override fun buildFoldRegions(
        root: PsiElement,
        document: Document,
        quick: Boolean
    ): Array<FoldingDescriptor> {
        val descriptors = mutableListOf<FoldingDescriptor>()
        root.accept(object : EbnfRecursiveVisitor() {
            override fun visitNonTerminal(o: EbnfNonTerminal) {
                super.visitNonTerminal(o)

                if (!EbnfPsiImplUtil.checkIfLhs(o)) {
                    val rules = findRulesByName(o.project, o.value)
                    if (rules.size == 1) {
                        descriptors.add(FoldingDescriptor(o.node, o.textRange, null, rules.toSet()))
                    }
                }
            }
        }
        )
        return descriptors.toTypedArray()
    }

    override fun getPlaceholderText(node: ASTNode): String? {
        return when (val psiElement = node.psi) {
            is EbnfNonTerminal -> {
                val rules = findRulesByName(psiElement.project, psiElement.value)
                if (rules.size == 1) {
                    "( ${EbnfPsiImplUtil.getDefinition(rules[0])?.text} )"
                } else {
                    StringUtil.THREE_DOTS
                }
            }
            else -> null
        }
    }

    override fun isCollapsedByDefault(node: ASTNode): Boolean = false
}