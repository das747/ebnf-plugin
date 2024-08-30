// This is a generated file. Not intended for manual editing.
package com.das747.ebnfplugin.lang.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.das747.ebnfplugin.lang.psi.EbnfTypes.*;
import com.das747.ebnfplugin.lang.psi.*;

public class EbnfAlternativeExprImpl extends EbnfTreeNodeImplMixin implements EbnfAlternativeExpr {

  public EbnfAlternativeExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull EbnfVisitor visitor) {
    visitor.visitAlternativeExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof EbnfVisitor) accept((EbnfVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<EbnfExpr> getExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, EbnfExpr.class);
  }

  @Override
  @NotNull
  public List<EbnfNonTerminal> getNonTerminalList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, EbnfNonTerminal.class);
  }

}
