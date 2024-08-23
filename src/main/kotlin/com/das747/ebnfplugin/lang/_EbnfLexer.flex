package com.das747.ebnfplugin.lang;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.das747.ebnfplugin.lang.psi.EbnfTypes.*;

%%

%{
  public _EbnfLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _EbnfLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

SPACE=[ \t\n\x0B\f\r]+
COMMENT="//".*
NUMBER=[0-9]+(\.[0-9]*)?
ID=[:letter:][a-zA-Z_0-9]*
STRING=('([^'\\]|\\.)*'|\"([^\"\\]|\\.)*\")

%%
<YYINITIAL> {
  {WHITE_SPACE}       { return WHITE_SPACE; }

  ":="                { return ASSN; }
  ";"                 { return SEMI; }
  "|"                 { return OR; }
  "{"                 { return CURL_L; }
  "}"                 { return CURL_R; }
  "["                 { return SQR_L; }
  "]"                 { return SQR_R; }
  "("                 { return BRACE_L; }
  ")"                 { return BRACE_R; }

  {SPACE}             { return SPACE; }
  {COMMENT}           { return COMMENT; }
  {NUMBER}            { return NUMBER; }
  {ID}                { return ID; }
  {STRING}            { return STRING; }

}

[^] { return BAD_CHARACTER; }
