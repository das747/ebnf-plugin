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

public class EbnfOptionalExprImpl extends EbnfTreeNodeImplMixin implements EbnfOptionalExpr {

  public EbnfOptionalExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull EbnfVisitor visitor) {
    visitor.visitOptionalExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof EbnfVisitor) accept((EbnfVisitor)visitor);
    else super.accept(visitor);
  }

}
