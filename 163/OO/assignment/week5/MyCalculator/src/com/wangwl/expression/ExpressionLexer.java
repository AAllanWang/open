/****************************************************************************
*                         A C A D E M I C   C O P Y
* 
* This file was produced by an ACADEMIC COPY of Parser Generator. It is for
* use in non-commercial software only. An ACADEMIC COPY of Parser Generator
* can only be used by a student, or a member of an academic community. If
* however you want to use Parser Generator for commercial purposes then you
* will need to purchase a license. For more information see the online help or
* go to the Bumble-Bee Software homepage at:
* 
* http://www.bumblebeesoftware.com
* 
* This notice must remain present in the file. It cannot be removed.
****************************************************************************/

/****************************************************************************
* ExpressionLexer.java
* Java source file generated from ExpressionLexer.l.
* 
* Date: 01/19/15
* Time: 15:11:50
* 
* ALex Version: 2.07
****************************************************************************/

// line 1 ".\\ExpressionLexer.l"

/****************************************************************************
ExpressionLexer.l
ParserWizard generated Lex file.

Date: Friday, January 16, 2015
****************************************************************************/
package com.wangwl.expression;
import java.io.InputStream;
import java.io.InputStreamReader;

// line 39 "ExpressionLexer.java"
import yl.*;

/////////////////////////////////////////////////////////////////////////////
// ExpressionLexer

public class ExpressionLexer extends yyflexer {
// line 21 ".\\ExpressionLexer.l"

	private yyparser parser;
	// Attributes

// line 51 "ExpressionLexer.java"
	public ExpressionLexer() {
		yytables();
// line 27 ".\\ExpressionLexer.l"

	parser = null;
	// do nothing

// line 59 "ExpressionLexer.java"
	}

	public static final int INITIAL = 0;

	protected static yyftables yytables = null;

	public final int yyaction(int action) {
// line 37 ".\\ExpressionLexer.l"

		// extract yylval for use later on in actions
		ExpressionParser.YYSTYPE yylval = (ExpressionParser.YYSTYPE)yyparserref.yylvalref;

// line 72 "ExpressionLexer.java"
		yyreturnflg = true;
		switch (action) {
		case 1:
		case 2:
		case 3:
			{
// line 48 ".\\ExpressionLexer.l"
 yylval.value = number(); return ExpressionParser.NUMBER; 
// line 81 "ExpressionLexer.java"
			}
		case 4:
			{
// line 51 ".\\ExpressionLexer.l"
 return ExpressionParser.SIN; 
// line 87 "ExpressionLexer.java"
			}
		case 5:
			{
// line 52 ".\\ExpressionLexer.l"
 return ExpressionParser.COS; 
// line 93 "ExpressionLexer.java"
			}
		case 6:
			{
// line 53 ".\\ExpressionLexer.l"
 return ExpressionParser.TAN; 
// line 99 "ExpressionLexer.java"
			}
		case 7:
			{
// line 54 ".\\ExpressionLexer.l"
 return ExpressionParser.LOG; 
// line 105 "ExpressionLexer.java"
			}
		case 8:
			{
// line 57 ".\\ExpressionLexer.l"
 return '='; 
// line 111 "ExpressionLexer.java"
			}
		case 9:
			{
// line 58 ".\\ExpressionLexer.l"
 return '+'; 
// line 117 "ExpressionLexer.java"
			}
		case 10:
			{
// line 59 ".\\ExpressionLexer.l"
 return '-'; 
// line 123 "ExpressionLexer.java"
			}
		case 11:
			{
// line 60 ".\\ExpressionLexer.l"
 return '*'; 
// line 129 "ExpressionLexer.java"
			}
		case 12:
			{
// line 61 ".\\ExpressionLexer.l"
 return '/'; 
// line 135 "ExpressionLexer.java"
			}
		case 13:
			{
// line 62 ".\\ExpressionLexer.l"
 return '%'; 
// line 141 "ExpressionLexer.java"
			}
		case 14:
			{
// line 63 ".\\ExpressionLexer.l"
 return '('; 
// line 147 "ExpressionLexer.java"
			}
		case 15:
			{
// line 64 ".\\ExpressionLexer.l"
 return ')'; 
// line 153 "ExpressionLexer.java"
			}
		case 16:
			{
// line 67 ".\\ExpressionLexer.l"
 return '\n'; 
// line 159 "ExpressionLexer.java"
			}
		case 17:
			{
// line 73 ".\\ExpressionLexer.l"
 /* do nothing */ 
// line 165 "ExpressionLexer.java"
			}
			break;
		case 18:
			{
// line 75 ".\\ExpressionLexer.l"
 invalidCharacter(); 
// line 172 "ExpressionLexer.java"
			}
			break;
		default:
			break;
		}
		yyreturnflg = false;
		return 0;
	}

	protected final void yytables() {
		yystext_size = 100;
		yysunput_size = 100;
		yytext_max = 0;
		yyunput_max = 0;

		yycreatetables();
		yymatch = yytables.yymatch;
		yytransition = yytables.yytransition;
		yystate = yytables.yystate;
		yybackup = yytables.yybackup;
	}

	public static synchronized final void yycreatetables() {
		if (yytables == null) {
			yytables = new yyftables();

			final short match[] = {
				0
			};
			yytables.yymatch = match;

			final yytransition transition[] = {
				new yytransition(0, 0),
				new yytransition(4, 1),
				new yytransition(5, 1),
				new yytransition(32, 24),
				new yytransition(22, 15),
				new yytransition(6, 1),
				new yytransition(15, 15),
				new yytransition(15, 15),
				new yytransition(15, 15),
				new yytransition(15, 15),
				new yytransition(15, 15),
				new yytransition(15, 15),
				new yytransition(15, 15),
				new yytransition(15, 15),
				new yytransition(15, 15),
				new yytransition(15, 15),
				new yytransition(33, 25),
				new yytransition(30, 23),
				new yytransition(0, 13),
				new yytransition(30, 23),
				new yytransition(36, 28),
				new yytransition(38, 29),
				new yytransition(36, 28),
				new yytransition(38, 29),
				new yytransition(4, 1),
				new yytransition(34, 26),
				new yytransition(35, 27),
				new yytransition(23, 15),
				new yytransition(26, 19),
				new yytransition(7, 1),
				new yytransition(27, 20),
				new yytransition(5, 6),
				new yytransition(8, 1),
				new yytransition(9, 1),
				new yytransition(10, 1),
				new yytransition(11, 1),
				new yytransition(24, 17),
				new yytransition(12, 1),
				new yytransition(13, 1),
				new yytransition(14, 1),
				new yytransition(15, 1),
				new yytransition(15, 1),
				new yytransition(15, 1),
				new yytransition(15, 1),
				new yytransition(15, 1),
				new yytransition(15, 1),
				new yytransition(15, 1),
				new yytransition(15, 1),
				new yytransition(15, 1),
				new yytransition(15, 1),
				new yytransition(0, 13),
				new yytransition(25, 18),
				new yytransition(0, 0),
				new yytransition(16, 1),
				new yytransition(0, 0),
				new yytransition(0, 0),
				new yytransition(0, 0),
				new yytransition(0, 0),
				new yytransition(0, 0),
				new yytransition(23, 15),
				new yytransition(21, 21),
				new yytransition(21, 21),
				new yytransition(21, 21),
				new yytransition(21, 21),
				new yytransition(21, 21),
				new yytransition(21, 21),
				new yytransition(21, 21),
				new yytransition(21, 21),
				new yytransition(21, 21),
				new yytransition(21, 21),
				new yytransition(0, 0),
				new yytransition(22, 22),
				new yytransition(22, 22),
				new yytransition(22, 22),
				new yytransition(22, 22),
				new yytransition(22, 22),
				new yytransition(22, 22),
				new yytransition(22, 22),
				new yytransition(22, 22),
				new yytransition(22, 22),
				new yytransition(22, 22),
				new yytransition(28, 21),
				new yytransition(0, 0),
				new yytransition(0, 0),
				new yytransition(0, 0),
				new yytransition(0, 0),
				new yytransition(0, 0),
				new yytransition(0, 0),
				new yytransition(0, 0),
				new yytransition(0, 0),
				new yytransition(0, 0),
				new yytransition(17, 1),
				new yytransition(29, 22),
				new yytransition(0, 0),
				new yytransition(0, 0),
				new yytransition(0, 0),
				new yytransition(0, 0),
				new yytransition(0, 0),
				new yytransition(0, 0),
				new yytransition(0, 0),
				new yytransition(18, 1),
				new yytransition(0, 0),
				new yytransition(0, 0),
				new yytransition(0, 0),
				new yytransition(0, 0),
				new yytransition(0, 0),
				new yytransition(0, 0),
				new yytransition(19, 1),
				new yytransition(20, 1),
				new yytransition(0, 0),
				new yytransition(0, 0),
				new yytransition(0, 0),
				new yytransition(0, 0),
				new yytransition(28, 21),
				new yytransition(31, 31),
				new yytransition(31, 31),
				new yytransition(31, 31),
				new yytransition(31, 31),
				new yytransition(31, 31),
				new yytransition(31, 31),
				new yytransition(31, 31),
				new yytransition(31, 31),
				new yytransition(31, 31),
				new yytransition(31, 31),
				new yytransition(29, 22),
				new yytransition(37, 37),
				new yytransition(37, 37),
				new yytransition(37, 37),
				new yytransition(37, 37),
				new yytransition(37, 37),
				new yytransition(37, 37),
				new yytransition(37, 37),
				new yytransition(37, 37),
				new yytransition(37, 37),
				new yytransition(37, 37),
				new yytransition(39, 39),
				new yytransition(39, 39),
				new yytransition(39, 39),
				new yytransition(39, 39),
				new yytransition(39, 39),
				new yytransition(39, 39),
				new yytransition(39, 39),
				new yytransition(39, 39),
				new yytransition(39, 39),
				new yytransition(39, 39)
			};
			yytables.yytransition = transition;

			final yystate state[] = {
				new yystate(0, 0, 0),
				new yystate(-3, -8, 0),
				new yystate(1, 0, 0),
				new yystate(0, 0, 18),
				new yystate(0, 0, 17),
				new yystate(0, 0, 16),
				new yystate(0, 21, 18),
				new yystate(0, 0, 13),
				new yystate(0, 0, 14),
				new yystate(0, 0, 15),
				new yystate(0, 0, 11),
				new yystate(0, 0, 9),
				new yystate(0, 0, 10),
				new yystate(21, -51, 18),
				new yystate(0, 0, 12),
				new yystate(0, -42, 3),
				new yystate(0, 0, 8),
				new yystate(0, -75, 18),
				new yystate(0, -60, 18),
				new yystate(0, -77, 18),
				new yystate(0, -67, 18),
				new yystate(0, 12, 2),
				new yystate(0, 23, 1),
				new yystate(31, -26, 0),
				new yystate(0, -112, 0),
				new yystate(0, -87, 0),
				new yystate(0, -85, 0),
				new yystate(0, -84, 0),
				new yystate(37, -23, 0),
				new yystate(39, -22, 0),
				new yystate(31, 0, 0),
				new yystate(0, 66, 3),
				new yystate(0, 0, 5),
				new yystate(0, 0, 7),
				new yystate(0, 0, 4),
				new yystate(0, 0, 6),
				new yystate(37, 0, 0),
				new yystate(0, 77, 2),
				new yystate(39, 0, 0),
				new yystate(0, 87, 1)
			};
			yytables.yystate = state;

			final boolean backup[] = {
				false,
				false,
				false,
				false,
				false,
				false,
				false,
				false,
				false,
				false,
				false,
				false,
				false,
				false,
				false,
				false,
				false,
				false,
				false
			};
			yytables.yybackup = backup;
		}
	}
// line 77 ".\\ExpressionLexer.l"


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

