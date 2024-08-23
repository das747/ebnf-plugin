package com.das747.ebnfplugin.lang

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class EbnfFile(viewProvider: FileViewProvider): PsiFileBase(viewProvider, EbnfLanguage) {
    override fun getFileType(): FileType = EbnfFileType

    override fun toString(): String = "EBNF File"
}