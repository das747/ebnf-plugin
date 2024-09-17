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
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
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

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(ALTERNATIVE_EXPR, CONCAT_EXPR, EXPR, GROUP_EXPR,
      MULTIPLE_EXPR, NON_ALTERNATIVE_EXPR, NON_TERMINAL, OPTIONAL_EXPR,
      TERMINAL),
  };

  /* ********************************************************** */
  // '|' non_alternative_expr
  static boolean alternative_clause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "alternative_clause")) return false;
    if (!nextTokenIs(b, OR)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, OR);
    p = r; // pin = 1
    r = r && non_alternative_expr(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // alternative_clause +
  public static boolean alternative_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "alternative_expr")) return false;
    if (!nextTokenIs(b, OR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, ALTERNATIVE_EXPR, null);
    r = alternative_clause(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!alternative_clause(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "alternative_expr", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (optional_expr | multiple_expr | group_expr | terminal | non_terminal) !(':=')
  static boolean atom_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_expr")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = atom_expr_0(b, l + 1);
    r = r && atom_expr_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // optional_expr | multiple_expr | group_expr | terminal | non_terminal
  private static boolean atom_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_expr_0")) return false;
    boolean r;
    r = optional_expr(b, l + 1);
    if (!r) r = multiple_expr(b, l + 1);
    if (!r) r = group_expr(b, l + 1);
    if (!r) r = terminal(b, l + 1);
    if (!r) r = non_terminal(b, l + 1);
    return r;
  }

  // !(':=')
  private static boolean atom_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_expr_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, ASSN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // !("]" | ")" | "}" | "|") rule_recover
  static boolean basic_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "basic_recover")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = basic_recover_0(b, l + 1);
    r = r && rule_recover(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !("]" | ")" | "}" | "|")
  private static boolean basic_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "basic_recover_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !basic_recover_0_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // "]" | ")" | "}" | "|"
  private static boolean basic_recover_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "basic_recover_0_0")) return false;
    boolean r;
    r = consumeToken(b, SQR_R);
    if (!r) r = consumeToken(b, BRACE_R);
    if (!r) r = consumeToken(b, CURL_R);
    if (!r) r = consumeToken(b, OR);
    return r;
  }

  /* ********************************************************** */
  // (atom_expr) +
  public static boolean concat_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "concat_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, CONCAT_EXPR, "<concat expr>");
    r = concat_expr_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!concat_expr_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "concat_expr", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (atom_expr)
  private static boolean concat_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "concat_expr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = atom_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // non_alternative_expr alternative_expr ?
  public static boolean expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, EXPR, "<expr>");
    r = non_alternative_expr(b, l + 1);
    r = r && expr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
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
  public static boolean group_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "group_expr")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, GROUP_EXPR, null);
    r = consumeToken(b, BRACE_L);
    r = r && expr(b, l + 1);
    p = r; // pin = 2
    r = r && consumeToken(b, BRACE_R);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // '{' expr '}'
  public static boolean multiple_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiple_expr")) return false;
    if (!nextTokenIs(b, CURL_L)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MULTIPLE_EXPR, null);
    r = consumeToken(b, CURL_L);
    r = r && expr(b, l + 1);
    p = r; // pin = 2
    r = r && consumeToken(b, CURL_R);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // atom_expr concat_expr?
  public static boolean non_alternative_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "non_alternative_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, NON_ALTERNATIVE_EXPR, "<non alternative expr>");
    r = atom_expr(b, l + 1);
    r = r && non_alternative_expr_1(b, l + 1);
    exit_section_(b, l, m, r, false, EbnfParser::basic_recover);
    return r;
  }

  // concat_expr?
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
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OPTIONAL_EXPR, null);
    r = consumeToken(b, SQR_L);
    r = r && expr(b, l + 1);
    p = r; // pin = 2
    r = r && consumeToken(b, SQR_R);
    exit_section_(b, l, m, r, p, null);
    return r || p;
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
  // !<<eof>> rule
  static boolean root_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root_item")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = root_item_0(b, l + 1);
    p = r; // pin = 1
    r = r && rule(b, l + 1);
    exit_section_(b, l, m, r, p, null);
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
  // non_terminal ':=' rule_body ';'
  public static boolean rule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rule")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, RULE, null);
    r = non_terminal(b, l + 1);
    r = r && consumeToken(b, ASSN);
    p = r; // pin = 2
    r = r && report_error_(b, rule_body(b, l + 1));
    r = p && consumeToken(b, SEMI) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // expr
  static boolean rule_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rule_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_);
    r = expr(b, l + 1);
    exit_section_(b, l, m, r, false, EbnfParser::rule_recover);
    return r;
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
