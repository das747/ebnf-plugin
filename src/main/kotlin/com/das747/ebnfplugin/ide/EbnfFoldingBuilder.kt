package com.das747.ebnfplugin.ide

import com.das747.ebnfplugin.lang.checkIfLhs
import com.das747.ebnfplugin.lang.findRulesByName
import com.das747.ebnfplugin.lang.getDefinition
import com.das747.ebnfplugin.lang.psi.EbnfNonTerminal
import com.das747.ebnfplugin.lang.psi.EbnfRecursiveVisitor
import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingBuilderEx
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.util.text.StringUtil
import com.intellij.psi.PsiElement

class EbnfFoldingBuilder : FoldingBuilderEx(), DumbAware {
    override fun buildFoldRegions(
        root: PsiElement,
        document: Document,
        quick: Boolean
    ): Array<FoldingDescriptor> {
        val descriptors = mutableListOf<FoldingDescriptor>()
        root.accept(object : EbnfRecursiveVisitor() {
            override fun visitNonTerminal(o: EbnfNonTerminal) {
                super.visitNonTerminal(o)

                if (!o.checkIfLhs()) {
                    val rules = o.containingFile.findRulesByName(o.value)
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
                val rules = psiElement.containingFile.findRulesByName(psiElement.value)
                if (rules.size == 1) {
                    "( ${rules[0].getDefinition()?.text} )"
                } else {
                    StringUtil.THREE_DOTS
                }
            }

            else -> null
        }
    }

    override fun isCollapsedByDefault(node: ASTNode): Boolean = false
}