package com.das747.ebnfplugin.ide

import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import javax.swing.Icon

fun createPresentationFor(
    element: PsiElement,
    text: String?,
    showLocation: Boolean = false
): ItemPresentation {
    return object : ItemPresentation {
        override fun getPresentableText(): String? {
            return text
        }

        override fun getIcon(unused: Boolean): Icon? {
            return element.getIcon(0)
        }

        override fun getLocationString(): String? {
            return if (showLocation) element.containingFile.name else null
        }

    }
}