package com.das747.ebnfplugin.lang.psi.impl

import com.das747.ebnfplugin.lang.psi.tree.EbnfExprNode
import com.intellij.lang.ASTNode

abstract class EbnfExprNodeImpl(node: ASTNode) : EbnfExprNode, EbnfExprImpl(node)