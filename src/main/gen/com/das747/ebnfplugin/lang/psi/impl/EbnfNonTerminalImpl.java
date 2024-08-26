// This is a generated file. Not intended for manual editing.
package com.das747.ebnfplugin.lang.psi.impl;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;

import static com.das747.ebnfplugin.lang.psi.EbnfTypes.*;
import com.das747.ebnfplugin.lang.psi.*;

public class EbnfNonTerminalImpl extends EbnfNonTerminalImplMixin implements EbnfNonTerminal {

  public EbnfNonTerminalImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull EbnfVisitor visitor) {
    visitor.visitNonTerminal(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof EbnfVisitor) accept((EbnfVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getId() {
    return findNotNullChildByType(ID);
  }

}
