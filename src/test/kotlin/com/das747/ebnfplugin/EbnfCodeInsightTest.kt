package com.das747.ebnfplugin

import com.das747.ebnfplugin.lang.EbnfFileType
import com.intellij.codeInsight.generation.actions.CommentByLineCommentAction
import com.intellij.testFramework.fixtures.BasePlatformTestCase

class EbnfCodeInsightTest: BasePlatformTestCase() {
    override fun getTestDataPath(): String = "src/test/kotlin/testData"

    fun testCompletion() {
        myFixture.configureByFile("CompletionTestData.ebnf")
        myFixture.completeBasic()
        val lookupElementStrings = myFixture.lookupElementStrings
        assertNotNull(lookupElementStrings)
        assertEquals(lookupElementStrings, listOf("first", "second", "third"))
    }

    fun testAnnotation() {
        myFixture.configureByFile("AnnotatorTestData.ebnf")
        myFixture.checkHighlighting(true, true, false, false)
    }

    fun testRename() {
        myFixture.configureByFile("RenameTestData.ebnf")
        myFixture.renameElementAtCaret("d")
        myFixture.checkResultByFile("RenameTestDataAfter.ebnf", false)
    }

    fun testFolding() {
        myFixture.configureByFile("FoldingTestData.ebnf")
        myFixture.testFolding("$testDataPath/FoldingTestData.ebnf")
    }

    fun testFindUsages() {
        val usagesInfo = myFixture.testFindUsages("FindUsagesTestData.ebnf")
        assertEquals(3, usagesInfo.size)
    }

    fun testCommenter() {
        myFixture.configureByText(EbnfFileType, "a := \"aaaa\";")
        CommentByLineCommentAction().run {
            actionPerformedImpl(project, myFixture.editor)
            myFixture.checkResult("// a := \"aaaa\";")
            actionPerformedImpl(project, myFixture.editor)
            myFixture.checkResult("a := \"aaaa\";")
        }
    }


}