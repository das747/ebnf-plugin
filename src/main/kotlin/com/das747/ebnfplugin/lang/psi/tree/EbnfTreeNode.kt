package com.das747.ebnfplugin.lang.psi.tree

interface EbnfTreeNode: EbnfExprNode {
    fun getChildrenExpr(): List<EbnfExprNode>
}