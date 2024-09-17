// This is a generated file. Not intended for manual editing.
package com.das747.ebnfplugin.lang.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;
import com.das747.ebnfplugin.lang.psi.tree.EbnfTreeNode;
import com.das747.ebnfplugin.lang.psi.tree.EbnfLeafNode;

public class EbnfVisitor extends PsiElementVisitor {

  public void visitAlternativeExpr(@NotNull EbnfAlternativeExpr o) {
    visitExpr(o);
    // visitTreeNode(o);
  }

  public void visitConcatExpr(@NotNull EbnfConcatExpr o) {
    visitExpr(o);
    // visitTreeNode(o);
  }

  public void visitExpr(@NotNull EbnfExpr o) {
    visitPsiElement(o);
  }

  public void visitGroupExpr(@NotNull EbnfGroupExpr o) {
    visitExpr(o);
    // visitTreeNode(o);
  }

  public void visitMultipleExpr(@NotNull EbnfMultipleExpr o) {
    visitExpr(o);
    // visitTreeNode(o);
  }

  public void visitNonTerminal(@NotNull EbnfNonTerminal o) {
    visitExpr(o);
    // visitLeafNode(o);
  }

  public void visitOptionalExpr(@NotNull EbnfOptionalExpr o) {
    visitExpr(o);
    // visitTreeNode(o);
  }

  public void visitRule(@NotNull EbnfRule o) {
    visitNamedElement(o);
  }

  public void visitTerminal(@NotNull EbnfTerminal o) {
    visitExpr(o);
    // visitLeafNode(o);
  }

  public void visitNamedElement(@NotNull EbnfNamedElement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
