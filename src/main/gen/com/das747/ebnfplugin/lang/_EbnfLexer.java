// Generated by JFlex 1.9.1 http://jflex.de/  (tweaked for IntelliJ platform)
// source: _EbnfLexer.flex

package com.das747.ebnfplugin.lang;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.das747.ebnfplugin.lang.psi.EbnfTypes.*;


public class _EbnfLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0, 0
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\1\u0100\1\u0200\1\u0300\1\u0400\1\u0500\1\u0600\1\u0700"+
    "\1\u0800\1\u0900\1\u0a00\1\u0b00\1\u0c00\1\u0d00\1\u0e00\1\u0f00"+
    "\1\u1000\1\u0100\1\u1100\1\u1200\1\u1300\1\u0100\1\u1400\1\u1500"+
    "\1\u1600\1\u1700\1\u1800\1\u1900\1\u1a00\1\u1b00\1\u0100\1\u1c00"+
    "\1\u1d00\1\u1e00\12\u1f00\1\u2000\1\u2100\1\u2200\1\u1f00\1\u2300"+
    "\1\u2400\2\u1f00\31\u0100\1\u2500\121\u0100\1\u2600\4\u0100\1\u2700"+
    "\1\u0100\1\u2800\1\u2900\1\u2a00\1\u2b00\1\u2c00\1\u2d00\53\u0100"+
    "\1\u2e00\10\u2f00\31\u1f00\1\u0100\1\u3000\1\u3100\1\u0100\1\u3200"+
    "\1\u3300\1\u3400\1\u3500\1\u1f00\1\u3600\1\u3700\1\u3800\1\u3900"+
    "\1\u0100\1\u3a00\1\u3b00\1\u3c00\1\u3d00\1\u3e00\1\u3f00\1\u4000"+
    "\1\u1f00\1\u4100\1\u4200\1\u4300\1\u4400\1\u4500\1\u4600\1\u4700"+
    "\1\u4800\1\u4900\1\u4a00\1\u4b00\1\u4c00\1\u1f00\1\u4d00\1\u4e00"+
    "\1\u4f00\1\u1f00\3\u0100\1\u5000\1\u5100\1\u5200\12\u1f00\4\u0100"+
    "\1\u5300\17\u1f00\2\u0100\1\u5400\41\u1f00\2\u0100\1\u5500\1\u5600"+
    "\2\u1f00\1\u5700\1\u5800\27\u0100\1\u5900\2\u0100\1\u5a00\45\u1f00"+
    "\1\u0100\1\u5b00\1\u5c00\11\u1f00\1\u5d00\27\u1f00\1\u5e00\1\u5f00"+
    "\1\u6000\1\u6100\11\u1f00\1\u6200\1\u6300\5\u1f00\1\u6400\1\u6500"+
    "\4\u1f00\1\u6600\21\u1f00\246\u0100\1\u6700\20\u0100\1\u6800\1\u6900"+
    "\25\u0100\1\u6a00\34\u0100\1\u6b00\14\u1f00\2\u0100\1\u6c00\u0e05\u1f00";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\11\0\1\1\4\2\22\0\1\1\1\0\1\3\4\0"+
    "\1\4\1\5\1\6\4\0\1\7\1\10\12\11\1\12"+
    "\1\13\1\0\1\14\3\0\32\15\1\16\1\17\1\20"+
    "\1\0\1\21\1\0\32\15\1\22\1\23\1\24\7\0"+
    "\1\2\32\0\1\1\11\0\1\25\12\0\1\25\4\0"+
    "\1\25\5\0\27\25\1\0\37\25\1\0\u01ca\25\4\0"+
    "\14\25\16\0\5\25\7\0\1\25\1\0\1\25\201\0"+
    "\5\25\1\0\2\25\2\0\4\25\1\0\1\25\6\0"+
    "\1\25\1\0\3\25\1\0\1\25\1\0\24\25\1\0"+
    "\123\25\1\0\213\25\10\0\246\25\1\0\46\25\2\0"+
    "\1\25\6\0\51\25\107\0\33\25\4\0\4\25\55\0"+
    "\53\25\43\0\2\25\1\0\143\25\1\0\1\25\17\0"+
    "\2\25\7\0\2\25\12\0\3\25\2\0\1\25\20\0"+
    "\1\25\1\0\36\25\35\0\131\25\13\0\1\25\30\0"+
    "\41\25\11\0\2\25\4\0\1\25\5\0\26\25\4\0"+
    "\1\25\11\0\1\25\3\0\1\25\27\0\31\25\7\0"+
    "\13\25\65\0\25\25\1\0\10\25\106\0\66\25\3\0"+
    "\1\25\22\0\1\25\7\0\12\25\17\0\20\25\4\0"+
    "\10\25\2\0\2\25\2\0\26\25\1\0\7\25\1\0"+
    "\1\25\3\0\4\25\3\0\1\25\20\0\1\25\15\0"+
    "\2\25\1\0\3\25\16\0\2\25\12\0\1\25\10\0"+
    "\6\25\4\0\2\25\2\0\26\25\1\0\7\25\1\0"+
    "\2\25\1\0\2\25\1\0\2\25\37\0\4\25\1\0"+
    "\1\25\23\0\3\25\20\0\11\25\1\0\3\25\1\0"+
    "\26\25\1\0\7\25\1\0\2\25\1\0\5\25\3\0"+
    "\1\25\22\0\1\25\17\0\2\25\27\0\1\25\13\0"+
    "\10\25\2\0\2\25\2\0\26\25\1\0\7\25\1\0"+
    "\2\25\1\0\5\25\3\0\1\25\36\0\2\25\1\0"+
    "\3\25\17\0\1\25\21\0\1\25\1\0\6\25\3\0"+
    "\3\25\1\0\4\25\3\0\2\25\1\0\1\25\1\0"+
    "\2\25\3\0\2\25\3\0\3\25\3\0\14\25\26\0"+
    "\1\25\64\0\10\25\1\0\3\25\1\0\27\25\1\0"+
    "\20\25\3\0\1\25\32\0\3\25\5\0\2\25\36\0"+
    "\1\25\4\0\10\25\1\0\3\25\1\0\27\25\1\0"+
    "\12\25\1\0\5\25\3\0\1\25\40\0\1\25\1\0"+
    "\2\25\17\0\2\25\22\0\10\25\1\0\3\25\1\0"+
    "\51\25\2\0\1\25\20\0\1\25\5\0\3\25\10\0"+
    "\3\25\30\0\6\25\5\0\22\25\3\0\30\25\1\0"+
    "\11\25\1\0\1\25\2\0\7\25\72\0\60\25\1\0"+
    "\2\25\14\0\7\25\72\0\2\25\1\0\1\25\1\0"+
    "\5\25\1\0\30\25\1\0\1\25\1\0\12\25\1\0"+
    "\2\25\11\0\1\25\2\0\5\25\1\0\1\25\25\0"+
    "\4\25\40\0\1\25\77\0\10\25\1\0\44\25\33\0"+
    "\5\25\163\0\53\25\24\0\1\25\20\0\6\25\4\0"+
    "\4\25\3\0\1\25\3\0\2\25\7\0\3\25\4\0"+
    "\15\25\14\0\1\25\21\0\46\25\1\0\1\25\5\0"+
    "\1\25\2\0\53\25\1\0\115\25\1\0\4\25\2\0"+
    "\7\25\1\0\1\25\1\0\4\25\2\0\51\25\1\0"+
    "\4\25\2\0\41\25\1\0\4\25\2\0\7\25\1\0"+
    "\1\25\1\0\4\25\2\0\17\25\1\0\71\25\1\0"+
    "\4\25\2\0\103\25\45\0\20\25\20\0\126\25\2\0"+
    "\6\25\3\0\u016c\25\2\0\21\25\1\1\32\25\5\0"+
    "\113\25\6\0\10\25\7\0\15\25\1\0\4\25\16\0"+
    "\22\25\16\0\22\25\16\0\15\25\1\0\3\25\17\0"+
    "\64\25\43\0\1\25\4\0\1\25\103\0\131\25\7\0"+
    "\5\25\2\0\42\25\1\0\1\25\5\0\106\25\12\0"+
    "\37\25\61\0\36\25\2\0\5\25\13\0\54\25\4\0"+
    "\32\25\66\0\27\25\11\0\65\25\122\0\1\25\135\0"+
    "\57\25\21\0\7\25\67\0\36\25\15\0\2\25\12\0"+
    "\54\25\32\0\44\25\51\0\3\25\12\0\44\25\2\0"+
    "\11\25\7\0\53\25\2\0\3\25\51\0\4\25\1\0"+
    "\6\25\1\0\2\25\3\0\1\25\5\0\300\25\100\0"+
    "\26\25\2\0\6\25\2\0\46\25\2\0\6\25\2\0"+
    "\10\25\1\0\1\25\1\0\1\25\1\0\1\25\1\0"+
    "\37\25\2\0\65\25\1\0\7\25\1\0\1\25\3\0"+
    "\3\25\1\0\7\25\3\0\4\25\2\0\6\25\4\0"+
    "\15\25\5\0\3\25\1\0\7\25\3\0\13\1\35\0"+
    "\2\2\5\0\1\1\57\0\1\1\21\0\1\25\15\0"+
    "\1\25\20\0\15\25\145\0\1\25\4\0\1\25\2\0"+
    "\12\25\1\0\1\25\3\0\5\25\6\0\1\25\1\0"+
    "\1\25\1\0\1\25\1\0\4\25\1\0\13\25\2\0"+
    "\4\25\5\0\5\25\4\0\1\25\64\0\2\25\u017b\0"+
    "\57\25\1\0\57\25\1\0\205\25\6\0\4\25\3\0"+
    "\2\25\14\0\46\25\1\0\1\25\5\0\1\25\2\0"+
    "\70\25\7\0\1\25\20\0\27\25\11\0\7\25\1\0"+
    "\7\25\1\0\7\25\1\0\7\25\1\0\7\25\1\0"+
    "\7\25\1\0\7\25\1\0\7\25\120\0\1\25\320\0"+
    "\1\1\4\0\2\25\52\0\5\25\5\0\2\25\4\0"+
    "\126\25\6\0\3\25\1\0\132\25\1\0\4\25\5\0"+
    "\53\25\1\0\136\25\21\0\33\25\65\0\306\25\112\0"+
    "\360\25\20\0\215\25\103\0\56\25\2\0\15\25\3\0"+
    "\20\25\12\0\2\25\24\0\57\25\20\0\37\25\2\0"+
    "\106\25\61\0\11\25\2\0\147\25\2\0\65\25\2\0"+
    "\5\25\60\0\13\25\1\0\3\25\1\0\4\25\1\0"+
    "\27\25\35\0\64\25\16\0\62\25\76\0\6\25\3\0"+
    "\1\25\1\0\2\25\13\0\34\25\12\0\27\25\31\0"+
    "\35\25\7\0\57\25\34\0\1\25\20\0\5\25\1\0"+
    "\12\25\12\0\5\25\1\0\51\25\27\0\3\25\1\0"+
    "\10\25\24\0\27\25\3\0\1\25\3\0\62\25\1\0"+
    "\1\25\3\0\2\25\2\0\5\25\2\0\1\25\1\0"+
    "\1\25\30\0\3\25\2\0\13\25\7\0\3\25\14\0"+
    "\6\25\2\0\6\25\2\0\6\25\11\0\7\25\1\0"+
    "\7\25\1\0\53\25\1\0\14\25\10\0\163\25\35\0"+
    "\244\25\14\0\27\25\4\0\61\25\4\0\u0100\26\156\25"+
    "\2\0\152\25\46\0\7\25\14\0\5\25\5\0\1\25"+
    "\1\0\12\25\1\0\15\25\1\0\5\25\1\0\1\25"+
    "\1\0\2\25\1\0\2\25\1\0\154\25\41\0\153\25"+
    "\22\0\100\25\2\0\66\25\50\0\14\25\164\0\5\25"+
    "\1\0\207\25\44\0\32\25\6\0\32\25\13\0\131\25"+
    "\3\0\6\25\2\0\6\25\2\0\6\25\2\0\3\25"+
    "\43\0\14\25\1\0\32\25\1\0\23\25\1\0\2\25"+
    "\1\0\17\25\2\0\16\25\42\0\173\25\205\0\35\25"+
    "\3\0\61\25\57\0\40\25\15\0\24\25\1\0\10\25"+
    "\6\0\46\25\12\0\36\25\2\0\44\25\4\0\10\25"+
    "\60\0\236\25\22\0\44\25\4\0\44\25\4\0\50\25"+
    "\10\0\64\25\234\0\67\25\11\0\26\25\12\0\10\25"+
    "\230\0\6\25\2\0\1\25\1\0\54\25\1\0\2\25"+
    "\3\0\1\25\2\0\27\25\12\0\27\25\11\0\37\25"+
    "\101\0\23\25\1\0\2\25\12\0\26\25\12\0\32\25"+
    "\106\0\70\25\6\0\2\25\100\0\1\25\17\0\4\25"+
    "\1\0\3\25\1\0\35\25\52\0\35\25\3\0\35\25"+
    "\43\0\10\25\1\0\34\25\33\0\66\25\12\0\26\25"+
    "\12\0\23\25\15\0\22\25\156\0\111\25\67\0\63\25"+
    "\15\0\63\25\15\0\44\25\334\0\35\25\12\0\1\25"+
    "\10\0\26\25\232\0\27\25\14\0\65\25\113\0\55\25"+
    "\40\0\31\25\32\0\44\25\35\0\1\25\13\0\43\25"+
    "\3\0\1\25\14\0\60\25\16\0\4\25\25\0\1\25"+
    "\1\0\1\25\43\0\22\25\1\0\31\25\124\0\7\25"+
    "\1\0\1\25\1\0\4\25\1\0\17\25\1\0\12\25"+
    "\7\0\57\25\46\0\10\25\2\0\2\25\2\0\26\25"+
    "\1\0\7\25\1\0\2\25\1\0\5\25\3\0\1\25"+
    "\22\0\1\25\14\0\5\25\236\0\65\25\22\0\4\25"+
    "\24\0\1\25\40\0\60\25\24\0\2\25\1\0\1\25"+
    "\270\0\57\25\51\0\4\25\44\0\60\25\24\0\1\25"+
    "\73\0\53\25\15\0\1\25\107\0\33\25\345\0\54\25"+
    "\164\0\100\25\37\0\1\25\240\0\10\25\2\0\47\25"+
    "\20\0\1\25\1\0\1\25\34\0\1\25\12\0\50\25"+
    "\7\0\1\25\25\0\1\25\13\0\56\25\23\0\1\25"+
    "\42\0\71\25\7\0\11\25\1\0\45\25\21\0\1\25"+
    "\61\0\36\25\160\0\7\25\1\0\2\25\1\0\46\25"+
    "\25\0\1\25\31\0\6\25\1\0\2\25\1\0\40\25"+
    "\16\0\1\25\u0147\0\23\25\15\0\232\25\346\0\304\25"+
    "\274\0\57\25\321\0\107\25\271\0\71\25\7\0\37\25"+
    "\161\0\36\25\22\0\60\25\20\0\4\25\37\0\25\25"+
    "\5\0\23\25\260\0\100\25\200\0\113\25\5\0\1\25"+
    "\102\0\15\25\100\0\2\25\1\0\1\25\34\0\370\25"+
    "\10\0\363\25\15\0\37\25\61\0\3\25\21\0\4\25"+
    "\10\0\u018c\25\4\0\153\25\5\0\15\25\3\0\11\25"+
    "\7\0\12\25\146\0\125\25\1\0\107\25\1\0\2\25"+
    "\2\0\1\25\2\0\2\25\2\0\4\25\1\0\14\25"+
    "\1\0\1\25\1\0\7\25\1\0\101\25\1\0\4\25"+
    "\2\0\10\25\1\0\7\25\1\0\34\25\1\0\4\25"+
    "\1\0\5\25\1\0\1\25\3\0\7\25\1\0\u0154\25"+
    "\2\0\31\25\1\0\31\25\1\0\37\25\1\0\31\25"+
    "\1\0\37\25\1\0\31\25\1\0\37\25\1\0\31\25"+
    "\1\0\37\25\1\0\31\25\1\0\10\25\64\0\55\25"+
    "\12\0\7\25\20\0\1\25\u0171\0\54\25\24\0\305\25"+
    "\73\0\104\25\7\0\1\25\264\0\4\25\1\0\33\25"+
    "\1\0\2\25\1\0\1\25\2\0\1\25\1\0\12\25"+
    "\1\0\4\25\1\0\1\25\1\0\1\25\6\0\1\25"+
    "\4\0\1\25\1\0\1\25\1\0\1\25\1\0\3\25"+
    "\1\0\2\25\1\0\1\25\2\0\1\25\1\0\1\25"+
    "\1\0\1\25\1\0\1\25\1\0\1\25\1\0\2\25"+
    "\1\0\1\25\2\0\4\25\1\0\7\25\1\0\4\25"+
    "\1\0\4\25\1\0\1\25\1\0\12\25\1\0\21\25"+
    "\5\0\3\25\1\0\5\25\1\0\21\25\104\0\327\25"+
    "\51\0\65\25\13\0\336\25\2\0\u0182\25\16\0\u0131\25"+
    "\37\0\36\25\342\0";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[27904];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\2\1\1\3\1\4\1\1\1\5"+
    "\1\1\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
    "\1\0\1\15\3\0\1\16\1\5\1\17";

  private static int [] zzUnpackAction() {
    int [] result = new int[25];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\27\0\56\0\105\0\134\0\27\0\27\0\163"+
    "\0\212\0\241\0\27\0\270\0\27\0\27\0\27\0\27"+
    "\0\27\0\105\0\27\0\317\0\134\0\346\0\375\0\u0114"+
    "\0\27";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[25];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length() - 1;
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpacktrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\2\3\1\4\1\5\1\6\1\7\1\2\1\10"+
    "\1\11\1\12\1\13\1\2\1\14\1\15\1\2\1\16"+
    "\1\2\1\17\1\20\1\21\1\14\1\2\30\0\2\3"+
    "\24\0\3\22\1\23\13\22\1\24\7\22\4\25\1\23"+
    "\12\25\1\26\7\25\10\0\1\27\25\0\1\30\1\0"+
    "\1\11\31\0\1\31\23\0\1\14\3\0\1\14\3\0"+
    "\1\14\5\0\2\22\1\0\23\22\1\0\2\25\1\0"+
    "\23\25\1\0\2\27\1\0\23\27\12\0\1\30\15\0";

  private static int [] zzUnpacktrans() {
    int [] result = new int[299];
    int offset = 0;
    offset = zzUnpacktrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpacktrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\3\1\2\11\3\1\1\11\1\1\5\11"+
    "\1\0\1\11\3\0\2\1\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[25];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** Number of newlines encountered up to the start of the matched text. */
  @SuppressWarnings("unused")
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  @SuppressWarnings("unused")
  protected int yycolumn;

  /** Number of characters up to the start of the matched text. */
  @SuppressWarnings("unused")
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  @SuppressWarnings("unused")
  private boolean zzEOFDone;

  /* user code: */
  public _EbnfLexer() {
    this((java.io.Reader)null);
  }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public _EbnfLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** Returns the maximum size of the scanner buffer, which limits the size of tokens. */
  private int zzMaxBufferLen() {
    return Integer.MAX_VALUE;
  }

  /**  Whether the scanner buffer can grow to accommodate a larger token. */
  private boolean zzCanGrow() {
    return true;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      {@code false}, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position {@code pos} from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException
  {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { return BAD_CHARACTER;
            }
          // fall through
          case 16: break;
          case 2:
            { return WHITE_SPACE;
            }
          // fall through
          case 17: break;
          case 3:
            { return BRACE_L;
            }
          // fall through
          case 18: break;
          case 4:
            { return BRACE_R;
            }
          // fall through
          case 19: break;
          case 5:
            { return NUMBER;
            }
          // fall through
          case 20: break;
          case 6:
            { return SEMI;
            }
          // fall through
          case 21: break;
          case 7:
            { return ID;
            }
          // fall through
          case 22: break;
          case 8:
            { return SQR_L;
            }
          // fall through
          case 23: break;
          case 9:
            { return SQR_R;
            }
          // fall through
          case 24: break;
          case 10:
            { return CURL_L;
            }
          // fall through
          case 25: break;
          case 11:
            { return OR;
            }
          // fall through
          case 26: break;
          case 12:
            { return CURL_R;
            }
          // fall through
          case 27: break;
          case 13:
            { return STRING;
            }
          // fall through
          case 28: break;
          case 14:
            { return COMMENT;
            }
          // fall through
          case 29: break;
          case 15:
            { return ASSN;
            }
          // fall through
          case 30: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
