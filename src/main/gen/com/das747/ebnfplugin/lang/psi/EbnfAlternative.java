// This is a generated file. Not intended for manual editing.
package com.das747.ebnfplugin.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface EbnfAlternative extends PsiElement {

  @NotNull
  List<EbnfConcat> getConcatList();

  @NotNull
  List<EbnfGroup> getGroupList();

  @NotNull
  List<EbnfNonTerminal> getNonTerminalList();

  @NotNull
  List<EbnfTerminal> getTerminalList();

  @NotNull
  List<EbnfZeroOrMore> getZeroOrMoreList();

  @NotNull
  List<EbnfZeroOrOne> getZeroOrOneList();

}
