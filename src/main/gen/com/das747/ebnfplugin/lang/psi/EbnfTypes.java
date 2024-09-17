// This is a generated file. Not intended for manual editing.
package com.das747.ebnfplugin.lang.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.das747.ebnfplugin.lang.psi.impl.*;

public interface EbnfTypes {

  IElementType ALTERNATIVE_EXPR = new EbnfElementType("ALTERNATIVE_EXPR");
  IElementType CONCAT_EXPR = new EbnfElementType("CONCAT_EXPR");
  IElementType EXPR = new EbnfElementType("EXPR");
  IElementType GROUP_EXPR = new EbnfElementType("GROUP_EXPR");
  IElementType MULTIPLE_EXPR = new EbnfElementType("MULTIPLE_EXPR");
  IElementType NON_TERMINAL = new EbnfElementType("NON_TERMINAL");
  IElementType OPTIONAL_EXPR = new EbnfElementType("OPTIONAL_EXPR");
  IElementType RULE = new EbnfElementType("RULE");
  IElementType TERMINAL = new EbnfElementType("TERMINAL");

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
      if (type == ALTERNATIVE_EXPR) {
        return new EbnfAlternativeExprImpl(node);
      }
      else if (type == CONCAT_EXPR) {
        return new EbnfConcatExprImpl(node);
      }
      else if (type == GROUP_EXPR) {
        return new EbnfGroupExprImpl(node);
      }
      else if (type == MULTIPLE_EXPR) {
        return new EbnfMultipleExprImpl(node);
      }
      else if (type == NON_TERMINAL) {
        return new EbnfNonTerminalImpl(node);
      }
      else if (type == OPTIONAL_EXPR) {
        return new EbnfOptionalExprImpl(node);
      }
      else if (type == RULE) {
        return new EbnfRuleImpl(node);
      }
      else if (type == TERMINAL) {
        return new EbnfTerminalImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
