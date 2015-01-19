%{
/****************************************************************************
ExpressionLexer.l
ParserWizard generated Lex file.

Date: Friday, January 16, 2015
****************************************************************************/
package com.wangwl.expression;
import java.io.InputStream;
import java.io.InputStreamReader;
%}

/////////////////////////////////////////////////////////////////////////////
// declarations section

// lexical analyser name
%name ExpressionLexer


// class definition
{
	private yyparser parser;
	// Attributes
}

// constructor
{
	parser = null;
	// do nothing
}

// macros
exponent	([Ee][+-]?[0-9]+)

%%

%{
		// extract yylval for use later on in actions
		ExpressionParser.YYSTYPE yylval = (ExpressionParser.YYSTYPE)yyparserref.yylvalref;
%}

// return expressions
%return

// number
[0-9]+"."[0-9]*{exponent}?	|
"."[0-9]+{exponent}?		|
[0-9]+{exponent}?			{ yylval.value = number(); return ExpressionParser.NUMBER; }

// keywords
"sin"						{ return ExpressionParser.SIN; }
"cos"						{ return ExpressionParser.COS; }
"tan"						{ return ExpressionParser.TAN; }
"log"						{ return ExpressionParser.LOG; }

// operators
"="							{ return '='; }
"+"							{ return '+'; }
"-"							{ return '-'; }
"*"							{ return '*'; }
"/"							{ return '/'; }
"%"							{ return '%'; }
"("							{ return '('; }
")"							{ return ')'; }

// white space
\r?\n						{ return '\n'; }

// break expressions
%break

// white space
[ \t]						{ /* do nothing */ }

.							{ invalidCharacter(); }

%%

	/////////////////////////////////////////////////////////////////////////////
	// ExpressionLexer commands

	public boolean create(ExpressionParser parser) {
		parser = parser;
		return yycreate(parser);
	}
	
	public void setInputStream(InputStream is){
		if(is != null){
			yyin = new InputStreamReader(is);
		}
	}

	/////////////////////////////////////////////////////////////////////////////
	// ExpressionLexer attribute commands

	protected double number() {
		String string = new String(yytext, 0, yyleng);
		try {
			Double number = new Double(string);
			if (number.isInfinite()) {
				if(parser != null){
					parser.yyerror("number too big");
				}
			}
			double value = number.doubleValue();
			return value;
		}
		catch (NumberFormatException e) {
			if(parser != null){
				parser.yyerror("Number format error");
			}
			return 0;
		}
	}

	protected void invalidCharacter() {
		String string = Integer.toString(yytext[0], 16);
		int length = string.length();
		int n = 4 - length;
		if (n > 0) {
			char[] pad = new char[n];
			for (int i = 0; i < n; i++) {
				pad[i] = '0';
			}
			string = pad + string;
		}
		if(parser != null){
			parser.yyerror("invalid character \'0x" + string + "\'");
		}
	}
}
