package com.das747.ebnfplugin.lang

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

object EbnfFileType : LanguageFileType(EbnfLanguage) {
    override fun getName(): String = "EBNF file"

    override fun getDescription(): String = "EBNF formal grammar file"

    override fun getDefaultExtension(): String = "ebnf"

    override fun getIcon(): Icon = EbnfIcons.FILE
}