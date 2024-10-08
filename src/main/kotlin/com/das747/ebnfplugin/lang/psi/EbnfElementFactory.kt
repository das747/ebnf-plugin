package com.das747.ebnfplugin.lang.psi

import com.das747.ebnfplugin.lang.EbnfFile
import com.das747.ebnfplugin.lang.EbnfFileType
import com.das747.ebnfplugin.lang.getDefinedNonTerminal
import com.das747.ebnfplugin.lang.getDefinition
import com.das747.ebnfplugin.lang.psi.EbnfTypes.*
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.tree.IElementType

object EbnfElementFactory {
    fun createNonTerminal(project: Project, name: String): EbnfNonTerminal {
        val file = createFile(project, "$name := a;")
        return file.findChildByClass(EbnfRule::class.java)!!.getDefinedNonTerminal()!!
    }

    private fun createExpression(project: Project, text: String): EbnfExpr {
        val file = createFile(project, "a := $text;")
        return file.findChildByClass(EbnfRule::class.java)!!.getDefinition()!!
    }

    fun createExpression(project: Project, type: IElementType, body: List<String>): EbnfExpr {
        val text = when (type) {
            ALTERNATIVE_EXPR -> body.joinToString(" | ")
            CONCAT_EXPR -> body.joinToString(" ")
            GROUP_EXPR -> "(${body.joinToString(" | ")})"
            OPTIONAL_EXPR -> "[${body.joinToString(" | ")}]"
            MULTIPLE_EXPR -> "{${body.joinToString(" | ")}}"
            else -> ""
        }
        return createExpression(project, text)
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