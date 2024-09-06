package com.das747.ebnfplugin.lang.psi

import com.intellij.openapi.progress.ProgressIndicatorProvider
import com.intellij.psi.PsiElement

abstract class EbnfRecursiveVisitor : EbnfVisitor() {
    override fun visitElement(element: PsiElement) {
        ProgressIndicatorProvider.checkCanceled()
        element.acceptChildren(this)
    }
}