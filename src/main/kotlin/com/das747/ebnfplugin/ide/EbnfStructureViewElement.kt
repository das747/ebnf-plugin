package com.das747.ebnfplugin.ide

import com.das747.ebnfplugin.lang.EbnfFile
import com.das747.ebnfplugin.lang.psi.EbnfPsiImplUtil
import com.das747.ebnfplugin.lang.psi.EbnfRule
import com.das747.ebnfplugin.lang.psi.impl.EbnfExprNodeImpl
import com.das747.ebnfplugin.lang.psi.impl.EbnfRuleImpl
import com.das747.ebnfplugin.lang.psi.tree.EbnfTreeNode
import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.util.PsiTreeUtil

class EbnfStructureViewElement(private val element: NavigatablePsiElement) : StructureViewTreeElement,
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

            is EbnfRule -> {
                EbnfPsiImplUtil.getDefinition(element)
                    ?.let { arrayOf(EbnfStructureViewElement(it as EbnfExprNodeImpl)) }
                    ?: emptyArray()
            }

            is EbnfTreeNode -> {
                element.getChildrenExpr().map { EbnfStructureViewElement(it as EbnfExprNodeImpl) }
                    .toTypedArray()
            }

            else -> emptyArray()
        }
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