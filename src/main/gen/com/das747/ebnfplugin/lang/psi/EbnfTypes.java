// This is a generated file. Not intended for manual editing.
package com.das747.ebnfplugin.lang.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.das747.ebnfplugin.lang.psi.impl.*;

public interface EbnfTypes {

  IElementType ALTERNATIVE = new EbnfElementType("ALTERNATIVE");
  IElementType CONCAT = new EbnfElementType("CONCAT");
  IElementType GROUP = new EbnfElementType("GROUP");
  IElementType NON_TERMINAL = new EbnfElementType("NON_TERMINAL");
  IElementType RULE = new EbnfElementType("RULE");
  IElementType TERMINAL = new EbnfElementType("TERMINAL");
  IElementType ZERO_OR_MORE = new EbnfElementType("ZERO_OR_MORE");
  IElementType ZERO_OR_ONE = new EbnfElementType("ZERO_OR_ONE");

  IElementType ASSN = new EbnfTokenType(":=");
  IElementType BRACE_L = new EbnfTokenType("(");
  IElementType BRACE_R = new EbnfTokenType(")");
  IElementType COMMENT = new EbnfTokenType("comment");
  IElementType CURL_L = new EbnfTokenType("{");
  IElementType CURL_R = new EbnfTokenType("}");
  IElementType ID = new EbnfTokenType("id");
  IElementType NUMBER = new EbnfTokenType("number");
  IElementType OR = new EbnfTokenType("|");
  IElementType SEMI = new EbnfTokenType(";");
  IElementType SQR_L = new EbnfTokenType("[");
  IElementType SQR_R = new EbnfTokenType("]");
  IElementType STRING = new EbnfTokenType("string");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ALTERNATIVE) {
        return new EbnfAlternativeImpl(node);
      }
      else if (type == CONCAT) {
        return new EbnfConcatImpl(node);
      }
      else if (type == GROUP) {
        return new EbnfGroupImpl(node);
      }
      else if (type == NON_TERMINAL) {
        return new EbnfNonTerminalImpl(node);
      }
      else if (type == RULE) {
        return new EbnfRuleImpl(node);
      }
      else if (type == TERMINAL) {
        return new EbnfTerminalImpl(node);
      }
      else if (type == ZERO_OR_MORE) {
        return new EbnfZeroOrMoreImpl(node);
      }
      else if (type == ZERO_OR_ONE) {
        return new EbnfZeroOrOneImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
