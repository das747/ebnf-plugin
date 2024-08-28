package com.das747.ebnfplugin.ide

import com.das747.ebnfplugin.lang.EbnfFile
import com.das747.ebnfplugin.lang.psi.EbnfRule
import com.das747.ebnfplugin.lang.psi.impl.EbnfRuleImpl
import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.util.PsiTreeUtil

class EbnfStructureViewElement(val element: NavigatablePsiElement) : StructureViewTreeElement,
    SortableTreeElement {

    override fun getPresentation(): ItemPresentation {
        return element.presentation ?: PresentationData()
    }

    override fun getChildren(): Array<TreeElement> {
        return when (element) {
            is EbnfFile -> {
                PsiTreeUtil.getChildrenOfType(element, EbnfRule::class.java)?.map {
                    EbnfStructureViewElement(it as EbnfRuleImpl)
                }?.toTypedArray() ?: emptyArray()
            }

            else -> emptyArray()
        }
    }

    override fun navigate(requestFocus: Boolean) {
        element.navigate(requestFocus)
    }

    override fun canNavigate(): Boolean = element.canNavigate()

    override fun canNavigateToSource(): Boolean = element.canNavigateToSource()

    override fun getValue(): Any = element

    override fun getAlphaSortKey(): String = element.name ?: ""

}