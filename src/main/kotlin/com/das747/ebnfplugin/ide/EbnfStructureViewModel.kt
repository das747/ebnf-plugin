package com.das747.ebnfplugin.ide

import com.das747.ebnfplugin.lang.psi.EbnfRule
import com.das747.ebnfplugin.lang.psi.tree.EbnfLeafNode
import com.intellij.ide.structureView.StructureViewModel
import com.intellij.ide.structureView.StructureViewModelBase
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.Sorter
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiFile

class EbnfStructureViewModel(editor: Editor?, psiFile: PsiFile) :
    StructureViewModelBase(psiFile, editor, EbnfStructureViewElement(psiFile)),
    StructureViewModel.ElementInfoProvider {

    override fun isAlwaysShowsPlus(element: StructureViewTreeElement?): Boolean = false

    override fun isAlwaysLeaf(element: StructureViewTreeElement?): Boolean {
        return element?.value is EbnfLeafNode
    }

    override fun getSuitableClasses(): Array<Class<*>> {
        return arrayOf(EbnfRule::class.java)
    }

    override fun getSorters(): Array<Sorter> {
        return arrayOf(Sorter.ALPHA_SORTER)
    }
}