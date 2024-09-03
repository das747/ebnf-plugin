package com.das747.ebnfplugin.lang

import com.das747.ebnfplugin.lang.psi.*
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil

fun findAllRules(project: Project): List<EbnfRule> {
    val result = mutableListOf<EbnfRule>()
    val virtualFiles = FileTypeIndex.getFiles(EbnfFileType, GlobalSearchScope.allScope(project))
    virtualFiles.forEach { file ->
        PsiManager.getInstance(project).findFile(file)?.let { ebnfFile ->
            PsiTreeUtil.getChildrenOfType(ebnfFile, EbnfRule::class.java)?.let { rules ->
                result.addAll(rules)
            }
        }
    }
    return result
}

fun findAllDefinedNonTerminals(project: Project): List<EbnfNonTerminal> {
    return findAllRules(project).mapNotNull { it.getDefinedNonTerminal() }
}

fun findRulesByName(project: Project, name: String): List<EbnfRule> {
    val result = mutableListOf<EbnfRule>()
    val virtualFiles = FileTypeIndex.getFiles(EbnfFileType, GlobalSearchScope.allScope(project))
    virtualFiles.forEach { file ->
        PsiManager.getInstance(project).findFile(file)?.let { ebnfFile ->
            PsiTreeUtil.getChildrenOfType(ebnfFile, EbnfRule::class.java)?.let { rules ->
                result.addAll(rules.filter { it.getDefinedNonTerminal()?.value == name })
            }
        }
    }
    return result
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