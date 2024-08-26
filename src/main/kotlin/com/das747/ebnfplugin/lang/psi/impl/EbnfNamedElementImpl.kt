package com.das747.ebnfplugin.lang.psi.impl

import com.das747.ebnfplugin.lang.psi.EbnfNamedElement
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

abstract class EbnfNamedElementImpl(node: ASTNode): EbnfNamedElement, ASTWrapperPsiElement(node)