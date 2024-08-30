package com.das747.ebnfplugin.lang.psi.impl

import com.das747.ebnfplugin.ide.createPresentationFor
import com.das747.ebnfplugin.lang.psi.EbnfAlternativeExpr
import com.das747.ebnfplugin.lang.psi.EbnfConcatExpr
import com.das747.ebnfplugin.lang.psi.EbnfMultipleExpr
import com.das747.ebnfplugin.lang.psi.EbnfNonTerminal
import com.das747.ebnfplugin.lang.psi.tree.EbnfExprNode
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import javax.swing.Icon

abstract class EbnfExprNodeImpl(node: ASTNode): EbnfExprNode, EbnfExprImpl(node) {


}