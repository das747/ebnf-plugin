// This is a generated file. Not intended for manual editing.
package com.das747.ebnfplugin.lang.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.das747.ebnfplugin.lang.psi.EbnfTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.das747.ebnfplugin.lang.psi.*;

public class EbnfAlternativeExprImpl extends ASTWrapperPsiElement implements EbnfAlternativeExpr {

  public EbnfAlternativeExprImpl(@NotNull ASTNode node) {
    super(node);
  }

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
  public List<EbnfAlternativeExpr> getAlternativeExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, EbnfAlternativeExpr.class);
  }

  @Override
  @NotNull
  public List<EbnfConcatExpr> getConcatExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, EbnfConcatExpr.class);
  }

  @Override
  @NotNull
  public List<EbnfMultipleExpr> getMultipleExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, EbnfMultipleExpr.class);
  }

  @Override
  @NotNull
  public List<EbnfNonTerminal> getNonTerminalList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, EbnfNonTerminal.class);
  }

  @Override
  @NotNull
  public List<EbnfOptionalExpr> getOptionalExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, EbnfOptionalExpr.class);
  }

  @Override
  @NotNull
  public List<EbnfTerminal> getTerminalList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, EbnfTerminal.class);
  }

}
