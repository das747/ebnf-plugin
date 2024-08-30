// This is a generated file. Not intended for manual editing.
package com.das747.ebnfplugin.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.das747.ebnfplugin.lang.psi.tree.EbnfTreeNode;

public interface EbnfAlternativeExpr extends EbnfExpr, EbnfTreeNode {

  @NotNull
  List<EbnfExpr> getExprList();

  @NotNull
  List<EbnfNonTerminal> getNonTerminalList();

}
