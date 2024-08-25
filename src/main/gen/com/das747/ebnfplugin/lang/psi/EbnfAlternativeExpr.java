// This is a generated file. Not intended for manual editing.
package com.das747.ebnfplugin.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface EbnfAlternativeExpr extends PsiElement {

  @NotNull
  List<EbnfAlternativeExpr> getAlternativeExprList();

  @NotNull
  List<EbnfConcatExpr> getConcatExprList();

  @NotNull
  List<EbnfMultipleExpr> getMultipleExprList();

  @NotNull
  List<EbnfNonTerminal> getNonTerminalList();

  @NotNull
  List<EbnfOptionalExpr> getOptionalExprList();

  @NotNull
  List<EbnfTerminal> getTerminalList();

}
