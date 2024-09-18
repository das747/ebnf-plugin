package com.das747.ebnfplugin.lang

import com.das747.ebnfplugin.lang.psi.*
import com.das747.ebnfplugin.lang.psi.tree.EbnfLeafNode
import com.das747.ebnfplugin.lang.psi.tree.EbnfTreeNode
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.elementType

fun findAllRules(project: Project): List<EbnfRule> {
    val result = mutableListOf<EbnfRule>()
    val virtualFiles = FileTypeIndex.getFiles(EbnfFileType, GlobalSearchScope.allScope(project))
    virtualFiles.forEach { file ->
        PsiManager.getInstance(project).findFile(file)?.let { ebnfFile ->
            if (ebnfFile is EbnfFile) result.addAll(ebnfFile.findAllRules())
        }
    }
    return result
}

fun PsiFile?.findAllRules(): List<EbnfRule> {
    if (this !is EbnfFile) return emptyList()
    return PsiTreeUtil.getChildrenOfTypeAsList(this, EbnfRule::class.java)
}

fun PsiFile?.findAllDefinedNonTerminals(): List<EbnfNonTerminal> {
    return findAllRules().mapNotNull { it.getDefinedNonTerminal() }
}

fun findAllDefinedNonTerminals(project: Project): List<EbnfNonTerminal> {
    return findAllRules(project).mapNotNull { it.getDefinedNonTerminal() }
}


fun PsiFile?.findRulesByName(name: String?): List<EbnfRule> {
    if (this !is EbnfFile) return emptyList()
    return findAllRules().filter { it.getDefinedNonTerminal()?.value == name }
}

fun EbnfRule.getDefinedNonTerminal(): EbnfNonTerminal? {
    return this.node.findChildByType(EbnfTypes.ASSN)?.let {
        PsiTreeUtil.getPrevSiblingOfType(it.psi, EbnfNonTerminal::class.java)
    }
}

fun EbnfRule.getDefinition(): EbnfExpr? {
    return this.node.findChildByType(EbnfTypes.ASSN)?.let {
        PsiTreeUtil.getNextSiblingOfType(it.psi, EbnfExpr::class.java)
    }
}

fun EbnfNonTerminal.checkIfLhs(): Boolean {
    return this.parent?.let {
        it is EbnfRule && it.getDefinedNonTerminal() == this
    } ?: false
}

fun PsiElement.getChildRange(child: PsiElement?): TextRange? {
    return child?.textRange?.shiftLeft(this.textRange.startOffset)
}

fun checkExpressionEquality(left: EbnfExpr, right: EbnfExpr): Boolean {
    return when {
        left == right -> true
        left.elementType != right.elementType -> false
        left is EbnfTreeNode && right is EbnfTreeNode -> {
            val leftChildren = left.getChildrenExpr()
            val rightChildren = right.getChildrenExpr()
            (leftChildren.size == rightChildren.size && leftChildren.zip(rightChildren)
                .all { (l, r) -> checkExpressionEquality(l, r) })
        }

        left is EbnfLeafNode && right is EbnfLeafNode -> {
            left.value == right.value
        }

        else -> false
    }
}

fun PsiElement.hasSameElementType(other: PsiElement): Boolean {
    return this == other || this.elementType == other.elementType
}

fun EbnfAlternativeExpr.deleteVariant(variant: EbnfExpr) {
    PsiTreeUtil.getPrevSiblingOfType(variant, EbnfExpr::class.java)?.let { prev ->
        this.deleteChildRange(prev.nextSibling, variant)
    } ?: PsiTreeUtil.getNextSiblingOfType(variant, EbnfExpr::class.java)?.let { next ->
        this.deleteChildRange(variant, next.prevSibling)
    } ?: variant.delete()
}