// This is a generated file. Not intended for manual editing.
package com.das747.ebnfplugin.lang.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class EbnfVisitor extends PsiElementVisitor {

  public void visitAlternativeExpr(@NotNull EbnfAlternativeExpr o) {
    visitPsiElement(o);
  }

  public void visitConcatExpr(@NotNull EbnfConcatExpr o) {
    visitPsiElement(o);
  }

  public void visitMultipleExpr(@NotNull EbnfMultipleExpr o) {
    visitPsiElement(o);
  }

  public void visitNonTerminal(@NotNull EbnfNonTerminal o) {
    visitPsiElement(o);
  }

  public void visitOptionalExpr(@NotNull EbnfOptionalExpr o) {
    visitPsiElement(o);
  }

  public void visitRule(@NotNull EbnfRule o) {
    visitPsiElement(o);
  }

  public void visitTerminal(@NotNull EbnfTerminal o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
