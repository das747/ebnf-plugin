// This is a generated file. Not intended for manual editing.
package com.das747.ebnfplugin.lang.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class EbnfVisitor extends PsiElementVisitor {

  public void visitAlternative(@NotNull EbnfAlternative o) {
    visitPsiElement(o);
  }

  public void visitConcat(@NotNull EbnfConcat o) {
    visitPsiElement(o);
  }

  public void visitGroup(@NotNull EbnfGroup o) {
    visitPsiElement(o);
  }

  public void visitNonTerminal(@NotNull EbnfNonTerminal o) {
    visitPsiElement(o);
  }

  public void visitRule(@NotNull EbnfRule o) {
    visitPsiElement(o);
  }

  public void visitTerminal(@NotNull EbnfTerminal o) {
    visitPsiElement(o);
  }

  public void visitZeroOrMore(@NotNull EbnfZeroOrMore o) {
    visitPsiElement(o);
  }

  public void visitZeroOrOne(@NotNull EbnfZeroOrOne o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
