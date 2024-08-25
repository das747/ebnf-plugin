package com.das747.ebnfplugin.lang

import com.das747.ebnfplugin.lang.parser.EbnfParser
import com.das747.ebnfplugin.lang.psi.EbnfTokenSets
import com.das747.ebnfplugin.lang.psi.EbnfTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet


val EbnfFileElementType = IFileElementType(EbnfLanguage)

class EbnfParserDefinition: ParserDefinition {
    override fun createLexer(project: Project?): Lexer = EbnfLexerAdapter()

    override fun createParser(project: Project?): PsiParser = EbnfParser()

    override fun getFileNodeType(): IFileElementType = EbnfFileElementType

    override fun getCommentTokens(): TokenSet = EbnfTokenSets.COMMENTS

    override fun getStringLiteralElements(): TokenSet = EbnfTokenSets.STRING_LITERALS

    override fun createElement(node: ASTNode?): PsiElement {
        return EbnfTypes.Factory.createElement(node)
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return EbnfFile(viewProvider)
    }
}