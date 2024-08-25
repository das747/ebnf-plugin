// This is a generated file. Not intended for manual editing.
package com.das747.ebnfplugin.lang.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class EbnfVisitor extends PsiElementVisitor {

  public void visitAlternativeExpr(@NotNull EbnfAlternativeExpr o) {
    visitExpr(o);
  }

  public void visitConcatExpr(@NotNull EbnfConcatExpr o) {
    visitExpr(o);
  }

  public void visitDefinition(@NotNull EbnfDefinition o) {
    visitPsiElement(o);
  }

  public void visitExpr(@NotNull EbnfExpr o) {
    visitPsiElement(o);
  }

  public void visitMultipleExpr(@NotNull EbnfMultipleExpr o) {
    visitExpr(o);
  }

  public void visitNonTerminal(@NotNull EbnfNonTerminal o) {
    visitExpr(o);
  }

  public void visitOptionalExpr(@NotNull EbnfOptionalExpr o) {
    visitExpr(o);
  }

  public void visitRule(@NotNull EbnfRule o) {
    visitPsiElement(o);
  }

  public void visitRuleName(@NotNull EbnfRuleName o) {
    visitPsiElement(o);
  }

  public void visitTerminal(@NotNull EbnfTerminal o) {
    visitExpr(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
