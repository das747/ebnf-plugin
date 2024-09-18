package com.das747.ebnfplugin.ide.intentions

import com.das747.ebnfplugin.lang.EbnfFile
import com.das747.ebnfplugin.lang.psi.EbnfElementFactory
import com.intellij.codeInsight.intention.impl.BaseIntentionAction
import com.intellij.codeInsight.intention.preview.IntentionPreviewInfo
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.pom.Navigatable
import com.intellij.psi.PsiFile


class EbnfCreateDefinitionIntention(private val name: String): BaseIntentionAction() {
    override fun getFamilyName(): String = "Create"

    override fun getText(): String = "Create definition for \"$name\""

    override fun isAvailable(project: Project, editor: Editor?, file: PsiFile?): Boolean = true

    override fun invoke(project: Project, editor: Editor?, file: PsiFile?) {
        val newRule = EbnfElementFactory.createRule(project, name, emptyList())
        if (file !is EbnfFile) return
        val addedRule = file.add(newRule)
        (addedRule.lastChild.navigationElement as Navigatable).navigate(true)
    }

    override fun generatePreview(
        project: Project,
        editor: Editor,
        file: PsiFile
    ): IntentionPreviewInfo {
        return IntentionPreviewInfo.EMPTY
    }
}
