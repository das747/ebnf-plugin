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

public class EbnfRuleImpl extends ASTWrapperPsiElement implements EbnfRule {

  public EbnfRuleImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull EbnfVisitor visitor) {
    visitor.visitRule(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof EbnfVisitor) accept((EbnfVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public EbnfAlternativeExpr getAlternativeExpr() {
    return findChildByClass(EbnfAlternativeExpr.class);
  }

  @Override
  @Nullable
  public EbnfConcatExpr getConcatExpr() {
    return findChildByClass(EbnfConcatExpr.class);
  }

  @Override
  @Nullable
  public EbnfMultipleExpr getMultipleExpr() {
    return findChildByClass(EbnfMultipleExpr.class);
  }

  @Override
  @NotNull
  public List<EbnfNonTerminal> getNonTerminalList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, EbnfNonTerminal.class);
  }

  @Override
  @Nullable
  public EbnfOptionalExpr getOptionalExpr() {
    return findChildByClass(EbnfOptionalExpr.class);
  }

  @Override
  @Nullable
  public EbnfTerminal getTerminal() {
    return findChildByClass(EbnfTerminal.class);
  }

}
