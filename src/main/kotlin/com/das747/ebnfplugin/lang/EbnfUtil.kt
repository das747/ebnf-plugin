package com.das747.ebnfplugin.lang

import com.das747.ebnfplugin.lang.psi.EbnfNonTerminal
import com.das747.ebnfplugin.lang.psi.EbnfPsiImplUtil
import com.das747.ebnfplugin.lang.psi.EbnfRule
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil

fun findDefinedNonTerminals(project: Project): List<EbnfNonTerminal> {
    val result = mutableListOf<EbnfNonTerminal>()
    val virtualFiles = FileTypeIndex.getFiles(EbnfFileType, GlobalSearchScope.allScope(project))
    virtualFiles.forEach { file ->
        PsiManager.getInstance(project).findFile(file)?.let { ebnfFile ->
            PsiTreeUtil.getChildrenOfType(ebnfFile, EbnfRule::class.java)?.let { rules ->
                result.addAll(rules.mapNotNull { EbnfPsiImplUtil.getDefinedNonTerminal(it) })
            }
        }
    }
    return result
}

fun findNonTerminal(project: Project, name: String): List<EbnfNonTerminal> {
    val result = mutableListOf<EbnfNonTerminal>()
    val virtualFiles = FileTypeIndex.getFiles(EbnfFileType, GlobalSearchScope.allScope(project))
    virtualFiles.forEach { file ->
        PsiManager.getInstance(project).findFile(file)?.let { ebnfFile ->
            PsiTreeUtil.getChildrenOfType(ebnfFile, EbnfRule::class.java)?.let { rules ->
                result.addAll(rules.mapNotNull { EbnfPsiImplUtil.getDefinedNonTerminal(it) }
                    .filter { it.id.text == name })
            }
        }
    }
    return result
}