// This is a generated file. Not intended for manual editing.
package com.das747.ebnfplugin.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface EbnfRule extends PsiElement {

  @Nullable
  EbnfAlternativeExpr getAlternativeExpr();

  @Nullable
  EbnfConcatExpr getConcatExpr();

  @Nullable
  EbnfMultipleExpr getMultipleExpr();

  @NotNull
  List<EbnfNonTerminal> getNonTerminalList();

  @Nullable
  EbnfOptionalExpr getOptionalExpr();

  @Nullable
  EbnfTerminal getTerminal();

}
