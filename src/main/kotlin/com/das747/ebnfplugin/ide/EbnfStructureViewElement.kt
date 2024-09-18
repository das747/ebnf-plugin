package com.das747.ebnfplugin.ide

import com.das747.ebnfplugin.lang.EbnfFile
import com.das747.ebnfplugin.lang.getDefinition
import com.das747.ebnfplugin.lang.psi.EbnfRule
import com.das747.ebnfplugin.lang.psi.impl.EbnfExprImpl
import com.das747.ebnfplugin.lang.psi.impl.EbnfGroupExprImpl
import com.das747.ebnfplugin.lang.psi.impl.EbnfRuleImpl
import com.das747.ebnfplugin.lang.psi.tree.EbnfTreeNode
import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.util.PsiTreeUtil

class EbnfStructureViewElement(private val element: NavigatablePsiElement) :
    StructureViewTreeElement,
    SortableTreeElement {

    override fun getPresentation(): ItemPresentation {
        return element.presentation ?: PresentationData()
    }

    override fun getChildren(): Array<TreeElement> {
        val children = when (element) {
            is EbnfFile -> {
                PsiTreeUtil.getChildrenOfType(element, EbnfRule::class.java)?.map {
                    it as EbnfRuleImpl
                }
            }

            is EbnfRule -> {
                element.getDefinition()?.let { listOf(it as EbnfExprImpl) }
            }

            is EbnfTreeNode -> {
                element.getChildrenExpr().map { it as EbnfExprImpl }
            }

            else -> emptyList()
        } ?: return emptyArray()

        return children.map { EbnfStructureViewElement(liftFromGroup(it)) }.toTypedArray()
    }

    private fun liftFromGroup(element: NavigatablePsiElement): NavigatablePsiElement {
        if (element !is EbnfGroupExprImpl) return element
        val child = element.getChildrenExpr().getOrNull(0) as EbnfExprImpl? ?: return element
        return liftFromGroup(child)
    }

    private val navigationTarget: NavigatablePsiElement
        get() {
            val referencedElement = element.reference?.resolve()
            return if (referencedElement is NavigatablePsiElement) {
                referencedElement
            } else {
                element
            }
        }

    override fun navigate(requestFocus: Boolean) {
        navigationTarget.navigate(requestFocus)
    }

    override fun canNavigate(): Boolean = navigationTarget.canNavigate()

    override fun canNavigateToSource(): Boolean = navigationTarget.canNavigateToSource()

    override fun getValue(): Any = element

    override fun getAlphaSortKey(): String = element.name ?: ""

}