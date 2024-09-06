package com.das747.ebnfplugin.ide

import com.das747.ebnfplugin.lang.psi.EbnfRule
import com.intellij.lang.refactoring.RefactoringSupportProvider
import com.intellij.psi.PsiElement

class EbnfRefactoringSupportProvider : RefactoringSupportProvider() {
    override fun isMemberInplaceRenameAvailable(
        element: PsiElement,
        context: PsiElement?
    ): Boolean {
        return element is EbnfRule
    }

    override fun isSafeDeleteAvailable(element: PsiElement): Boolean {
        return element is EbnfRule
    }
}