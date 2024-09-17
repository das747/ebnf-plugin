package com.das747.ebnfplugin.lang.psi

import com.das747.ebnfplugin.lang.EbnfFile
import com.das747.ebnfplugin.lang.EbnfFileType
import com.das747.ebnfplugin.lang.getDefinedNonTerminal
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFileFactory

object EbnfElementFactory {
    fun createNonTerminal(project: Project, name: String): EbnfNonTerminal {
        val file = createFile(project, "$name := a;")

        return file.findChildByClass(EbnfRule::class.java)!!.getDefinedNonTerminal()!!
    }

    fun createRule(project: Project, name: String, definitions: List<String>): EbnfRule {
        val file = createFile(project, "$name := ${definitions.joinToString(" | ")};")
        return file.findChildByClass(EbnfRule::class.java)!!
    }

    fun createFile(project: Project, text: String): EbnfFile {
        val name = "dummy.ebnf"
        return PsiFileFactory.getInstance(project)
            .createFileFromText(name, EbnfFileType, text) as EbnfFile
    }
}