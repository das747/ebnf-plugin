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
  // pattern alternative_op*
  public static boolean alternative(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "alternative")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ALTERNATIVE, "<alternative>");
    r = pattern(b, l + 1);
    r = r && alternative_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // alternative_op*
  private static boolean alternative_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "alternative_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!alternative_op(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "alternative_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // '|' pattern
  static boolean alternative_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "alternative_op")) return false;
    if (!nextTokenIs(b, OR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OR);
    r = r && pattern(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // pattern +
  public static boolean concat(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "concat")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, CONCAT, "<concat>");
    r = pattern(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!pattern(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "concat", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // terminal | non-terminal
  static boolean element(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element")) return false;
    if (!nextTokenIs(b, "", ID, STRING)) return false;
    boolean r;
    r = terminal(b, l + 1);
    if (!r) r = non_terminal(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // '(' alternative ')'
  public static boolean group(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "group")) return false;
    if (!nextTokenIs(b, BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACE_L);
    r = r && alternative(b, l + 1);
    r = r && consumeToken(b, BRACE_R);
    exit_section_(b, m, GROUP, r);
    return r;
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
  // element concat* | zeroOrMore | zeroOrOne | group
  static boolean pattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = pattern_0(b, l + 1);
    if (!r) r = zeroOrMore(b, l + 1);
    if (!r) r = zeroOrOne(b, l + 1);
    if (!r) r = group(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // element concat*
  private static boolean pattern_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = element(b, l + 1);
    r = r && pattern_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // concat*
  private static boolean pattern_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!concat(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "pattern_0_1", c)) break;
    }
    return true;
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
  // non-terminal ':=' alternative
  public static boolean rule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rule")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, RULE, null);
    r = non_terminal(b, l + 1);
    r = r && consumeToken(b, ASSN);
    p = r; // pin = 2
    r = r && alternative(b, l + 1);
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

  /* ********************************************************** */
  // '{' alternative '}'
  public static boolean zeroOrMore(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "zeroOrMore")) return false;
    if (!nextTokenIs(b, CURL_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CURL_L);
    r = r && alternative(b, l + 1);
    r = r && consumeToken(b, CURL_R);
    exit_section_(b, m, ZERO_OR_MORE, r);
    return r;
  }

  /* ********************************************************** */
  // '[' alternative ']'
  public static boolean zeroOrOne(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "zeroOrOne")) return false;
    if (!nextTokenIs(b, SQR_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SQR_L);
    r = r && alternative(b, l + 1);
    r = r && consumeToken(b, SQR_R);
    exit_section_(b, m, ZERO_OR_ONE, r);
    return r;
  }

}
