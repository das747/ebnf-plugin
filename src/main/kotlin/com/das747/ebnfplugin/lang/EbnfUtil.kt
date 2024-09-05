package com.das747.ebnfplugin.lang

import com.das747.ebnfplugin.lang.psi.*
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil

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

fun EbnfFile?.findAllRules(): List<EbnfRule> {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, EbnfRule::class.java)
}

fun EbnfFile?.findAllDefinedNonTerminals(): List<EbnfNonTerminal> {
    return findAllRules().mapNotNull { it.getDefinedNonTerminal() }
}

fun findAllDefinedNonTerminals(project: Project): List<EbnfNonTerminal> {
    return findAllRules(project).mapNotNull { it.getDefinedNonTerminal() }
}


fun PsiFile?.findRulesByName(name: String): List<EbnfRule> {
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