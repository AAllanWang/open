%{
/****************************************************************************
ExpressionParser.y
ParserWizard generated YACC file.

Date: Friday, January 16, 2015
****************************************************************************/
package com.wangwl.expression;
import java.lang.Math;
import java.io.ByteArrayInputStream;
%}

/////////////////////////////////////////////////////////////////////////////
// declarations section

// parser name
%name ExpressionParser


// class definition
{
	// Attributes
	protected ExpressionLexer lexer;		// the lexical analyser
	private String strExprValue;
}

// constructor
{
	// do nothing
	strExprValue = "";
	create();
	
}

// attribute type
%union {
	public double value;

	// copy method
	public void yycopy(yyattribute source, boolean move) {
		YYSTYPE yy = (YYSTYPE)source;
		value = yy.value;
	}
}

// nonterminals
%type <value> expr

// tokens
%left '+', '-'
%left '*', '/' ,'%'
%right UMINUS

%token <value> NUMBER

// keywords
%token SIN
%token COS
%token TAN
%token LOG

%%

line
	: expr '='					{ strExprValue= String.valueOf($1);}
	| error '\n'				{ yyerrok();}
	;

expr
	: expr '+' expr				{ $$ = $1 + $3; }
	| expr '-' expr				{ $$ = $1 - $3; }
	| expr '*' expr				{ $$ = $1 * $3; }
	| expr '/' expr				{ $$ = divide($1, $3); }
	| expr '%' expr				{ $$ = $1 % $3; }
	| '(' expr ')'				{ $$ = $2; }
	| '-' expr %prec UMINUS		{ $$ = -$2; }
	| NUMBER					{ $$ = $1; }
	| SIN '(' expr ')'			{ $$ = Math.sin($3); }
	| COS '(' expr ')'			{ $$ = Math.cos($3); }
	| TAN '(' expr ')'			{ $$ = Math.tan($3); }
	| LOG '(' expr ')'			{ $$ = Math.log10($3); }
	;

%%

	/////////////////////////////////////////////////////////////////////////////
	// main
/*
	public static void main(String args[]) {
		ExpressionParser parser = new ExpressionParser();
		System.out.println(parser.eval("1.5+3*(10.2-9.2)+5/2="));
		System.out.println(parser.eval("1.5/0="));
		System.out.println(parser.eval("(((90+1)))="));
	}
*/
	/////////////////////////////////////////////////////////////////////////////
	// ExpressionParser commands

	private boolean create() {

		lexer = new ExpressionLexer();
		if (!yycreate(lexer)) {
			return false;
		}
		if (!lexer.create(this)) {
			return false;
		}
		return true;	// success
	}
	
	public String eval(String strExpression){
	
		lexer.setInputStream(new ByteArrayInputStream(strExpression.getBytes()));
		yyparse();
		return strExprValue;
	}

	/////////////////////////////////////////////////////////////////////////////
	// ExpressionParser attribute commands
	protected double divide(double a, double b) {
		if (b == 0) {
			yyerror("division by zero");
			yythrowerror();		// causes a syntax error
			return 0;
		}
		else {
			return a / b;
		}
	}
	
	public void yyerror(String text){
		strExprValue = text;
	}
}
