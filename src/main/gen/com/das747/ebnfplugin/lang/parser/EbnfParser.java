// This is a generated file. Not intended for manual editing.
package com.das747.ebnfplugin.lang.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.das747.ebnfplugin.lang.psi.EbnfTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class EbnfParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return root(b, l + 1);
  }

  /* ********************************************************** */
  // ('|' non_alternative_expr) +
  public static boolean alternative_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "alternative_expr")) return false;
    if (!nextTokenIs(b, OR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, ALTERNATIVE_EXPR, null);
    r = alternative_expr_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!alternative_expr_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "alternative_expr", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '|' non_alternative_expr
  private static boolean alternative_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "alternative_expr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OR);
    r = r && non_alternative_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // optional_expr | multiple_expr | group_expr | terminal | non_terminal
  static boolean atom_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_expr")) return false;
    boolean r;
    r = optional_expr(b, l + 1);
    if (!r) r = multiple_expr(b, l + 1);
    if (!r) r = group_expr(b, l + 1);
    if (!r) r = terminal(b, l + 1);
    if (!r) r = non_terminal(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // atom_expr +
  public static boolean concat_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "concat_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, CONCAT_EXPR, "<concat expr>");
    r = atom_expr(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!atom_expr(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "concat_expr", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // non_alternative_expr alternative_expr ?
  static boolean expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = non_alternative_expr(b, l + 1);
    r = r && expr_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // alternative_expr ?
  private static boolean expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_1")) return false;
    alternative_expr(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // '(' expr ')'
  static boolean group_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "group_expr")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACE_L);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, BRACE_R);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '{' expr '}'
  public static boolean multiple_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiple_expr")) return false;
    if (!nextTokenIs(b, CURL_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CURL_L);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, CURL_R);
    exit_section_(b, m, MULTIPLE_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // atom_expr concat_expr ?
  static boolean non_alternative_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "non_alternative_expr")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = atom_expr(b, l + 1);
    r = r && non_alternative_expr_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // concat_expr ?
  private static boolean non_alternative_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "non_alternative_expr_1")) return false;
    concat_expr(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // id
  public static boolean non_terminal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "non_terminal")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    exit_section_(b, m, NON_TERMINAL, r);
    return r;
  }

  /* ********************************************************** */
  // '[' expr ']'
  public static boolean optional_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "optional_expr")) return false;
    if (!nextTokenIs(b, SQR_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SQR_L);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, SQR_R);
    exit_section_(b, m, OPTIONAL_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // root_item *
  static boolean root(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root")) return false;
    while (true) {
      int c = current_position_(b);
      if (!root_item(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "root", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // !<<eof>> rule ';'
  static boolean root_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root_item")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = root_item_0(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, rule(b, l + 1));
    r = p && consumeToken(b, SEMI) && r;
    exit_section_(b, l, m, r, p, EbnfParser::rule_recover);
    return r || p;
  }

  // !<<eof>>
  private static boolean root_item_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root_item_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !eof(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // non_terminal ':=' expr
  public static boolean rule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rule")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, RULE, null);
    r = non_terminal(b, l + 1);
    r = r && consumeToken(b, ASSN);
    p = r; // pin = 2
    r = r && expr(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // !(';' | id ':=')
  static boolean rule_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rule_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !rule_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ';' | id ':='
  private static boolean rule_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rule_recover_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEMI);
    if (!r) r = parseTokens(b, 0, ID, ASSN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // string
  public static boolean terminal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "terminal")) return false;
    if (!nextTokenIs(b, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING);
    exit_section_(b, m, TERMINAL, r);
    return r;
  }

}
