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
* ExpressionParser.java
* Java source file generated from ExpressionParser.y.
* 
* Date: 01/19/15
* Time: 15:11:50
* 
* AYACC Version: 2.07
****************************************************************************/

// line 1 ".\\ExpressionParser.y"

/****************************************************************************
ExpressionParser.y
ParserWizard generated YACC file.

Date: Friday, January 16, 2015
****************************************************************************/
package com.wangwl.expression;
import java.lang.Math;
import java.io.ByteArrayInputStream;

// line 39 "ExpressionParser.java"
import yl.*;

/////////////////////////////////////////////////////////////////////////////
// ExpressionParser

public class ExpressionParser extends yyfparser {
// line 21 ".\\ExpressionParser.y"

	// Attributes
	protected ExpressionLexer lexer;		// the lexical analyser
	private String strExprValue;

// line 52 "ExpressionParser.java"
	public ExpressionParser() {
		yytables();
// line 28 ".\\ExpressionParser.y"

	// do nothing
	strExprValue = "";
	create();
	

// line 62 "ExpressionParser.java"
	}

	public class YYSTYPE extends yyattribute {
// line 36 ".\\ExpressionParser.y"

	public double value;

	// copy method
	public void yycopy(yyattribute source, boolean move) {
		YYSTYPE yy = (YYSTYPE)source;
		value = yy.value;
	}

// line 76 "ExpressionParser.java"
	}

	public static final int UMINUS = 65537;
	public static final int NUMBER = 65538;
	public static final int SIN = 65539;
	public static final int COS = 65540;
	public static final int TAN = 65541;
	public static final int LOG = 65542;
	protected final YYSTYPE yyattribute(int index) {
		YYSTYPE attribute = (YYSTYPE)yyattributestackref[yytop + index];
		return attribute;
	}

	protected final yyattribute yynewattribute() {
		return new YYSTYPE();
	}

	protected final YYSTYPE[] yyinitdebug(int count) {
		YYSTYPE a[] = new YYSTYPE[count];
		for (int i = 0; i < count; i++) {
			a[i] = (YYSTYPE)yyattributestackref[yytop + i - (count - 1)];
		}
		return a;
	}

	protected static yyftables yytables = null;

	public final void yyaction(int action) {
		switch (action) {
		case 0:
			{
				YYSTYPE yya[];
				if (YYDEBUG) {
					yya = yyinitdebug(3);
				}
// line 65 ".\\ExpressionParser.y"
 strExprValue= String.valueOf(yyattribute(1 - 2).value);
// line 114 "ExpressionParser.java"
			}
			break;
		case 1:
			{
				YYSTYPE yya[];
				if (YYDEBUG) {
					yya = yyinitdebug(3);
				}
// line 66 ".\\ExpressionParser.y"
 yyerrok();
// line 125 "ExpressionParser.java"
			}
			break;
		case 2:
			{
				YYSTYPE yya[];
				if (YYDEBUG) {
					yya = yyinitdebug(4);
				}
// line 70 ".\\ExpressionParser.y"
 ((YYSTYPE)yyvalref).value = yyattribute(1 - 3).value + yyattribute(3 - 3).value; 
// line 136 "ExpressionParser.java"
			}
			break;
		case 3:
			{
				YYSTYPE yya[];
				if (YYDEBUG) {
					yya = yyinitdebug(4);
				}
// line 71 ".\\ExpressionParser.y"
 ((YYSTYPE)yyvalref).value = yyattribute(1 - 3).value - yyattribute(3 - 3).value; 
// line 147 "ExpressionParser.java"
			}
			break;
		case 4:
			{
				YYSTYPE yya[];
				if (YYDEBUG) {
					yya = yyinitdebug(4);
				}
// line 72 ".\\ExpressionParser.y"
 ((YYSTYPE)yyvalref).value = yyattribute(1 - 3).value * yyattribute(3 - 3).value; 
// line 158 "ExpressionParser.java"
			}
			break;
		case 5:
			{
				YYSTYPE yya[];
				if (YYDEBUG) {
					yya = yyinitdebug(4);
				}
// line 73 ".\\ExpressionParser.y"
 ((YYSTYPE)yyvalref).value = divide(yyattribute(1 - 3).value, yyattribute(3 - 3).value); 
// line 169 "ExpressionParser.java"
			}
			break;
		case 6:
			{
				YYSTYPE yya[];
				if (YYDEBUG) {
					yya = yyinitdebug(4);
				}
// line 74 ".\\ExpressionParser.y"
 ((YYSTYPE)yyvalref).value = yyattribute(1 - 3).value % yyattribute(3 - 3).value; 
// line 180 "ExpressionParser.java"
			}
			break;
		case 7:
			{
				YYSTYPE yya[];
				if (YYDEBUG) {
					yya = yyinitdebug(4);
				}
// line 75 ".\\ExpressionParser.y"
 ((YYSTYPE)yyvalref).value = yyattribute(2 - 3).value; 
// line 191 "ExpressionParser.java"
			}
			break;
		case 8:
			{
				YYSTYPE yya[];
				if (YYDEBUG) {
					yya = yyinitdebug(3);
				}
// line 76 ".\\ExpressionParser.y"
 ((YYSTYPE)yyvalref).value = -yyattribute(2 - 2).value; 
// line 202 "ExpressionParser.java"
			}
			break;
		case 9:
			{
				YYSTYPE yya[];
				if (YYDEBUG) {
					yya = yyinitdebug(2);
				}
// line 77 ".\\ExpressionParser.y"
 ((YYSTYPE)yyvalref).value = yyattribute(1 - 1).value; 
// line 213 "ExpressionParser.java"
			}
			break;
		case 10:
			{
				YYSTYPE yya[];
				if (YYDEBUG) {
					yya = yyinitdebug(5);
				}
// line 78 ".\\ExpressionParser.y"
 ((YYSTYPE)yyvalref).value = Math.sin(yyattribute(3 - 4).value); 
// line 224 "ExpressionParser.java"
			}
			break;
		case 11:
			{
				YYSTYPE yya[];
				if (YYDEBUG) {
					yya = yyinitdebug(5);
				}
// line 79 ".\\ExpressionParser.y"
 ((YYSTYPE)yyvalref).value = Math.cos(yyattribute(3 - 4).value); 
// line 235 "ExpressionParser.java"
			}
			break;
		case 12:
			{
				YYSTYPE yya[];
				if (YYDEBUG) {
					yya = yyinitdebug(5);
				}
// line 80 ".\\ExpressionParser.y"
 ((YYSTYPE)yyvalref).value = Math.tan(yyattribute(3 - 4).value); 
// line 246 "ExpressionParser.java"
			}
			break;
		case 13:
			{
				YYSTYPE yya[];
				if (YYDEBUG) {
					yya = yyinitdebug(5);
				}
// line 81 ".\\ExpressionParser.y"
 ((YYSTYPE)yyvalref).value = Math.log10(yyattribute(3 - 4).value); 
// line 257 "ExpressionParser.java"
			}
			break;
		default:
			break;
		}
	}

	protected final void yytables() {
		yysstack_size = 100;
		yystack_max = 0;

		yycreatetables();
		yysymbol = yytables.yysymbol;
		yyrule = yytables.yyrule;
		yyreduction = yytables.yyreduction;
		yytokenaction = yytables.yytokenaction;
		yystateaction = yytables.yystateaction;
		yynontermgoto = yytables.yynontermgoto;
		yystategoto = yytables.yystategoto;
		yydestructorref = yytables.yydestructorref;
		yytokendestref = yytables.yytokendestref;
		yytokendestbaseref = yytables.yytokendestbaseref;
	}

	public static synchronized final void yycreatetables() {
		if (yytables == null) {
			yytables = new yyftables();

			if (YYDEBUG) {
				final yysymbol symbol[] = {
					new yysymbol("$end", 0),
					new yysymbol("\'\\n\'", 10),
					new yysymbol("\'%\'", 37),
					new yysymbol("\'(\'", 40),
					new yysymbol("\')\'", 41),
					new yysymbol("\'*\'", 42),
					new yysymbol("\'+\'", 43),
					new yysymbol("\'-\'", 45),
					new yysymbol("\'/\'", 47),
					new yysymbol("\'=\'", 61),
					new yysymbol("error", 65536),
					new yysymbol("UMINUS", 65537),
					new yysymbol("NUMBER", 65538),
					new yysymbol("SIN", 65539),
					new yysymbol("COS", 65540),
					new yysymbol("TAN", 65541),
					new yysymbol("LOG", 65542),
					new yysymbol(null, 0)
				};
				yytables.yysymbol = symbol;

				final String rule[] = {
					"$accept: line",
					"line: expr \'=\'",
					"line: error \'\\n\'",
					"expr: expr \'+\' expr",
					"expr: expr \'-\' expr",
					"expr: expr \'*\' expr",
					"expr: expr \'/\' expr",
					"expr: expr \'%\' expr",
					"expr: \'(\' expr \')\'",
					"expr: \'-\' expr",
					"expr: NUMBER",
					"expr: SIN \'(\' expr \')\'",
					"expr: COS \'(\' expr \')\'",
					"expr: TAN \'(\' expr \')\'",
					"expr: LOG \'(\' expr \')\'"
				};
				yytables.yyrule = rule;
			}

			final yyreduction reduction[] = {
				new yyreduction(0, 1, -1),
				new yyreduction(1, 2, 0),
				new yyreduction(1, 2, 1),
				new yyreduction(2, 3, 2),
				new yyreduction(2, 3, 3),
				new yyreduction(2, 3, 4),
				new yyreduction(2, 3, 5),
				new yyreduction(2, 3, 6),
				new yyreduction(2, 3, 7),
				new yyreduction(2, 2, 8),
				new yyreduction(2, 1, 9),
				new yyreduction(2, 4, 10),
				new yyreduction(2, 4, 11),
				new yyreduction(2, 4, 12),
				new yyreduction(2, 4, 13)
			};
			yytables.yyreduction = reduction;

			final yytokenaction tokenaction[] = {
				new yytokenaction(28, YYAT_SHIFT, 18),
				new yytokenaction(9, YYAT_ERROR, 0),
				new yytokenaction(22, YYAT_SHIFT, 1),
				new yytokenaction(27, YYAT_SHIFT, 36),
				new yytokenaction(28, YYAT_SHIFT, 37),
				new yytokenaction(28, YYAT_SHIFT, 19),
				new yytokenaction(28, YYAT_SHIFT, 20),
				new yytokenaction(22, YYAT_SHIFT, 2),
				new yytokenaction(28, YYAT_SHIFT, 21),
				new yytokenaction(26, YYAT_SHIFT, 35),
				new yytokenaction(28, YYAT_SHIFT, 22),
				new yytokenaction(38, YYAT_SHIFT, 4),
				new yytokenaction(38, YYAT_SHIFT, 5),
				new yytokenaction(38, YYAT_SHIFT, 6),
				new yytokenaction(38, YYAT_SHIFT, 7),
				new yytokenaction(38, YYAT_SHIFT, 8),
				new yytokenaction(25, YYAT_SHIFT, 34),
				new yytokenaction(32, YYAT_SHIFT, 18),
				new yytokenaction(31, YYAT_SHIFT, 18),
				new yytokenaction(11, YYAT_SHIFT, 24),
				new yytokenaction(10, YYAT_ACCEPT, 0),
				new yytokenaction(9, YYAT_SHIFT, 23),
				new yytokenaction(32, YYAT_SHIFT, 19),
				new yytokenaction(31, YYAT_SHIFT, 19),
				new yytokenaction(8, YYAT_SHIFT, 17),
				new yytokenaction(7, YYAT_SHIFT, 16),
				new yytokenaction(6, YYAT_SHIFT, 15),
				new yytokenaction(32, YYAT_SHIFT, 22),
				new yytokenaction(31, YYAT_SHIFT, 22),
				new yytokenaction(5, YYAT_SHIFT, 14),
				new yytokenaction(3, YYAT_SHIFT, 13),
				new yytokenaction(0, YYAT_SHIFT, 3)
			};
			yytables.yytokenaction = tokenaction;

			final yystateaction stateaction[] = {
				new yystateaction(-65505, true, YYAT_DEFAULT, 22),
				new yystateaction(0, false, YYAT_DEFAULT, 22),
				new yystateaction(0, false, YYAT_DEFAULT, 22),
				new yystateaction(20, true, YYAT_ERROR, 0),
				new yystateaction(0, false, YYAT_REDUCE, 10),
				new yystateaction(-11, true, YYAT_ERROR, 0),
				new yystateaction(-14, true, YYAT_ERROR, 0),
				new yystateaction(-15, true, YYAT_ERROR, 0),
				new yystateaction(-16, true, YYAT_ERROR, 0),
				new yystateaction(-40, true, YYAT_DEFAULT, 28),
				new yystateaction(20, true, YYAT_ERROR, 0),
				new yystateaction(-22, true, YYAT_DEFAULT, 28),
				new yystateaction(0, false, YYAT_REDUCE, 9),
				new yystateaction(0, false, YYAT_REDUCE, 2),
				new yystateaction(0, false, YYAT_DEFAULT, 22),
				new yystateaction(0, false, YYAT_DEFAULT, 22),
				new yystateaction(0, false, YYAT_DEFAULT, 22),
				new yystateaction(0, false, YYAT_DEFAULT, 22),
				new yystateaction(0, false, YYAT_DEFAULT, 22),
				new yystateaction(0, false, YYAT_DEFAULT, 22),
				new yystateaction(0, false, YYAT_DEFAULT, 22),
				new yystateaction(0, false, YYAT_DEFAULT, 22),
				new yystateaction(-38, true, YYAT_DEFAULT, 38),
				new yystateaction(0, false, YYAT_REDUCE, 1),
				new yystateaction(0, false, YYAT_REDUCE, 8),
				new yystateaction(-25, true, YYAT_DEFAULT, 28),
				new yystateaction(-32, true, YYAT_DEFAULT, 28),
				new yystateaction(-38, true, YYAT_DEFAULT, 28),
				new yystateaction(-37, true, YYAT_ERROR, 0),
				new yystateaction(0, false, YYAT_REDUCE, 7),
				new yystateaction(0, false, YYAT_REDUCE, 5),
				new yystateaction(-19, true, YYAT_REDUCE, 3),
				new yystateaction(-20, true, YYAT_REDUCE, 4),
				new yystateaction(0, false, YYAT_REDUCE, 6),
				new yystateaction(0, false, YYAT_REDUCE, 11),
				new yystateaction(0, false, YYAT_REDUCE, 12),
				new yystateaction(0, false, YYAT_REDUCE, 13),
				new yystateaction(0, false, YYAT_REDUCE, 14),
				new yystateaction(-65527, true, YYAT_ERROR, 0)
			};
			yytables.yystateaction = stateaction;

			final yynontermgoto nontermgoto[] = {
				new yynontermgoto(0, 10),
				new yynontermgoto(0, 9),
				new yynontermgoto(22, 33),
				new yynontermgoto(21, 32),
				new yynontermgoto(20, 31),
				new yynontermgoto(19, 30),
				new yynontermgoto(18, 29),
				new yynontermgoto(17, 28),
				new yynontermgoto(16, 27),
				new yynontermgoto(15, 26),
				new yynontermgoto(14, 25),
				new yynontermgoto(2, 12),
				new yynontermgoto(1, 11)
			};
			yytables.yynontermgoto = nontermgoto;

			final yystategoto stategoto[] = {
				new yystategoto(-1, -1),
				new yystategoto(10, -1),
				new yystategoto(9, -1),
				new yystategoto(0, -1),
				new yystategoto(0, -1),
				new yystategoto(0, -1),
				new yystategoto(0, -1),
				new yystategoto(0, -1),
				new yystategoto(0, -1),
				new yystategoto(0, -1),
				new yystategoto(0, -1),
				new yystategoto(0, -1),
				new yystategoto(0, -1),
				new yystategoto(0, -1),
				new yystategoto(8, -1),
				new yystategoto(7, -1),
				new yystategoto(6, -1),
				new yystategoto(5, -1),
				new yystategoto(4, -1),
				new yystategoto(3, -1),
				new yystategoto(2, -1),
				new yystategoto(1, -1),
				new yystategoto(0, -1),
				new yystategoto(0, -1),
				new yystategoto(0, -1),
				new yystategoto(0, -1),
				new yystategoto(0, -1),
				new yystategoto(0, -1),
				new yystategoto(0, -1),
				new yystategoto(0, -1),
				new yystategoto(0, -1),
				new yystategoto(0, -1),
				new yystategoto(0, -1),
				new yystategoto(0, -1),
				new yystategoto(0, -1),
				new yystategoto(0, -1),
				new yystategoto(0, -1),
				new yystategoto(0, -1),
				new yystategoto(0, -1)
			};
			yytables.yystategoto = stategoto;

			yytables.yydestructorref = null;

			yytables.yytokendestref = null;

			yytables.yytokendestbaseref = null;
		}
	}
// line 84 ".\\ExpressionParser.y"


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

