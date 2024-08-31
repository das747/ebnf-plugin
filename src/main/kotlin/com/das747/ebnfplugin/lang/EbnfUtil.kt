package com.das747.ebnfplugin.lang

import com.das747.ebnfplugin.lang.psi.EbnfNonTerminal
import com.das747.ebnfplugin.lang.psi.EbnfPsiImplUtil
import com.das747.ebnfplugin.lang.psi.EbnfRule
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
    return findAllRules(project).mapNotNull { EbnfPsiImplUtil.getDefinedNonTerminal(it) }
}

fun findRulesByName(project: Project, name: String): List<EbnfRule> {
    val result = mutableListOf<EbnfRule>()
    val virtualFiles = FileTypeIndex.getFiles(EbnfFileType, GlobalSearchScope.allScope(project))
    virtualFiles.forEach { file ->
        PsiManager.getInstance(project).findFile(file)?.let { ebnfFile ->
            PsiTreeUtil.getChildrenOfType(ebnfFile, EbnfRule::class.java)?.let { rules ->
                result.addAll(rules.filter { EbnfPsiImplUtil.getDefinedNonTerminal(it)?.value == name })
            }
        }
    }
    return result
}