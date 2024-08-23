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

public class EbnfAlternativeImpl extends ASTWrapperPsiElement implements EbnfAlternative {

  public EbnfAlternativeImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull EbnfVisitor visitor) {
    visitor.visitAlternative(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof EbnfVisitor) accept((EbnfVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<EbnfConcat> getConcatList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, EbnfConcat.class);
  }

  @Override
  @NotNull
  public List<EbnfGroup> getGroupList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, EbnfGroup.class);
  }

  @Override
  @NotNull
  public List<EbnfNonTerminal> getNonTerminalList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, EbnfNonTerminal.class);
  }

  @Override
  @NotNull
  public List<EbnfTerminal> getTerminalList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, EbnfTerminal.class);
  }

  @Override
  @NotNull
  public List<EbnfZeroOrMore> getZeroOrMoreList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, EbnfZeroOrMore.class);
  }

  @Override
  @NotNull
  public List<EbnfZeroOrOne> getZeroOrOneList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, EbnfZeroOrOne.class);
  }

}
