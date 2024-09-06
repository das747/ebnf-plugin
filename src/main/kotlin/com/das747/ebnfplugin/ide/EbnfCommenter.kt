package com.das747.ebnfplugin.ide

import com.intellij.lang.Commenter

class EbnfCommenter : Commenter {
    override fun getLineCommentPrefix(): String? = "// "

    override fun getBlockCommentPrefix(): String? = null

    override fun getBlockCommentSuffix(): String? = null

    override fun getCommentedBlockCommentPrefix(): String? = null

    override fun getCommentedBlockCommentSuffix(): String? = null
}