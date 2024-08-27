package com.das747.ebnfplugin.lang.psi.impl

import com.das747.ebnfplugin.lang.psi.EbnfElementFactory
import com.das747.ebnfplugin.lang.psi.EbnfPsiImplUtil
import com.das747.ebnfplugin.lang.psi.EbnfRule
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement

abstract class EbnfRuleImplMixin(node: ASTNode): EbnfRule, EbnfNamedElementImpl(node) {
    override fun setName(name: String): PsiElement {
        EbnfPsiImplUtil.getDefinedNonTerminal(this)?.let { oldName ->
            val newName = EbnfElementFactory.createNonTerminal(this.project, name)
            this.node.replaceChild(oldName.node, newName.node)
        }
        return this
    }

    override fun getName(): String? {
        return nameIdentifier?.text
    }

    override fun getNameIdentifier(): PsiElement? {
        return EbnfPsiImplUtil.getDefinedNonTerminal(this)
    }

}