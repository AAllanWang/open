#############################################################################
#                         A C A D E M I C   C O P Y
# 
# This file was produced by an ACADEMIC COPY of Parser Generator. It is for
# use in non-commercial software only. An ACADEMIC COPY of Parser Generator
# can only be used by a student, or a member of an academic community. If
# however you want to use Parser Generator for commercial purposes then you
# will need to purchase a license. For more information see the online help or
# go to the Bumble-Bee Software homepage at:
# 
# http://www.bumblebeesoftware.com
# 
# This notice must remain present in the file. It cannot be removed.
#############################################################################

#############################################################################
# ExpressionParser.v
# YACC verbose file generated from ExpressionParser.y.
# 
# Date: 01/19/15
# Time: 15:11:50
# 
# AYACC Version: 2.07
#############################################################################


##############################################################################
# Rules
##############################################################################

    0  $accept : line $end

    1  line : expr '='
    2       | error '\n'

    3  expr : expr '+' expr
    4       | expr '-' expr
    5       | expr '*' expr
    6       | expr '/' expr
    7       | expr '%' expr
    8       | '(' expr ')'
    9       | '-' expr
   10       | NUMBER
   11       | SIN '(' expr ')'
   12       | COS '(' expr ')'
   13       | TAN '(' expr ')'
   14       | LOG '(' expr ')'


##############################################################################
# States
##############################################################################

state 0
	$accept : . line $end

	'('  shift 1
	'-'  shift 2
	error  shift 3
	NUMBER  shift 4
	SIN  shift 5
	COS  shift 6
	TAN  shift 7
	LOG  shift 8

	expr  goto 9
	line  goto 10


state 1
	expr : '(' . expr ')'

	'('  shift 1
	'-'  shift 2
	NUMBER  shift 4
	SIN  shift 5
	COS  shift 6
	TAN  shift 7
	LOG  shift 8

	expr  goto 11


state 2
	expr : '-' . expr

	'('  shift 1
	'-'  shift 2
	NUMBER  shift 4
	SIN  shift 5
	COS  shift 6
	TAN  shift 7
	LOG  shift 8

	expr  goto 12


state 3
	line : error . '\n'

	'\n'  shift 13


state 4
	expr : NUMBER .  (10)

	.  reduce 10


state 5
	expr : SIN . '(' expr ')'

	'('  shift 14


state 6
	expr : COS . '(' expr ')'

	'('  shift 15


state 7
	expr : TAN . '(' expr ')'

	'('  shift 16


state 8
	expr : LOG . '(' expr ')'

	'('  shift 17


state 9
	expr : expr . '+' expr
	expr : expr . '-' expr
	expr : expr . '*' expr
	expr : expr . '/' expr
	expr : expr . '%' expr
	line : expr . '='

	'%'  shift 18
	'*'  shift 19
	'+'  shift 20
	'-'  shift 21
	'/'  shift 22
	'='  shift 23


state 10
	$accept : line . $end  (0)

	$end  accept


state 11
	expr : expr . '+' expr
	expr : expr . '-' expr
	expr : expr . '*' expr
	expr : expr . '/' expr
	expr : expr . '%' expr
	expr : '(' expr . ')'

	'%'  shift 18
	')'  shift 24
	'*'  shift 19
	'+'  shift 20
	'-'  shift 21
	'/'  shift 22


state 12
	expr : expr . '+' expr
	expr : expr . '-' expr
	expr : expr . '*' expr
	expr : expr . '/' expr
	expr : expr . '%' expr
	expr : '-' expr .  (9)

	.  reduce 9


state 13
	line : error '\n' .  (2)

	.  reduce 2


state 14
	expr : SIN '(' . expr ')'

	'('  shift 1
	'-'  shift 2
	NUMBER  shift 4
	SIN  shift 5
	COS  shift 6
	TAN  shift 7
	LOG  shift 8

	expr  goto 25


state 15
	expr : COS '(' . expr ')'

	'('  shift 1
	'-'  shift 2
	NUMBER  shift 4
	SIN  shift 5
	COS  shift 6
	TAN  shift 7
	LOG  shift 8

	expr  goto 26


state 16
	expr : TAN '(' . expr ')'

	'('  shift 1
	'-'  shift 2
	NUMBER  shift 4
	SIN  shift 5
	COS  shift 6
	TAN  shift 7
	LOG  shift 8

	expr  goto 27


state 17
	expr : LOG '(' . expr ')'

	'('  shift 1
	'-'  shift 2
	NUMBER  shift 4
	SIN  shift 5
	COS  shift 6
	TAN  shift 7
	LOG  shift 8

	expr  goto 28


state 18
	expr : expr '%' . expr

	'('  shift 1
	'-'  shift 2
	NUMBER  shift 4
	SIN  shift 5
	COS  shift 6
	TAN  shift 7
	LOG  shift 8

	expr  goto 29


state 19
	expr : expr '*' . expr

	'('  shift 1
	'-'  shift 2
	NUMBER  shift 4
	SIN  shift 5
	COS  shift 6
	TAN  shift 7
	LOG  shift 8

	expr  goto 30


state 20
	expr : expr '+' . expr

	'('  shift 1
	'-'  shift 2
	NUMBER  shift 4
	SIN  shift 5
	COS  shift 6
	TAN  shift 7
	LOG  shift 8

	expr  goto 31


state 21
	expr : expr '-' . expr

	'('  shift 1
	'-'  shift 2
	NUMBER  shift 4
	SIN  shift 5
	COS  shift 6
	TAN  shift 7
	LOG  shift 8

	expr  goto 32


state 22
	expr : expr '/' . expr

	'('  shift 1
	'-'  shift 2
	NUMBER  shift 4
	SIN  shift 5
	COS  shift 6
	TAN  shift 7
	LOG  shift 8

	expr  goto 33


state 23
	line : expr '=' .  (1)

	.  reduce 1


state 24
	expr : '(' expr ')' .  (8)

	.  reduce 8


state 25
	expr : expr . '+' expr
	expr : expr . '-' expr
	expr : expr . '*' expr
	expr : expr . '/' expr
	expr : expr . '%' expr
	expr : SIN '(' expr . ')'

	'%'  shift 18
	')'  shift 34
	'*'  shift 19
	'+'  shift 20
	'-'  shift 21
	'/'  shift 22


state 26
	expr : expr . '+' expr
	expr : expr . '-' expr
	expr : expr . '*' expr
	expr : expr . '/' expr
	expr : expr . '%' expr
	expr : COS '(' expr . ')'

	'%'  shift 18
	')'  shift 35
	'*'  shift 19
	'+'  shift 20
	'-'  shift 21
	'/'  shift 22


state 27
	expr : expr . '+' expr
	expr : expr . '-' expr
	expr : expr . '*' expr
	expr : expr . '/' expr
	expr : expr . '%' expr
	expr : TAN '(' expr . ')'

	'%'  shift 18
	')'  shift 36
	'*'  shift 19
	'+'  shift 20
	'-'  shift 21
	'/'  shift 22


state 28
	expr : expr . '+' expr
	expr : expr . '-' expr
	expr : expr . '*' expr
	expr : expr . '/' expr
	expr : expr . '%' expr
	expr : LOG '(' expr . ')'

	'%'  shift 18
	')'  shift 37
	'*'  shift 19
	'+'  shift 20
	'-'  shift 21
	'/'  shift 22


state 29
	expr : expr . '+' expr
	expr : expr . '-' expr
	expr : expr . '*' expr
	expr : expr . '/' expr
	expr : expr '%' expr .  (7)
	expr : expr . '%' expr

	.  reduce 7


state 30
	expr : expr . '+' expr
	expr : expr . '-' expr
	expr : expr '*' expr .  (5)
	expr : expr . '*' expr
	expr : expr . '/' expr
	expr : expr . '%' expr

	.  reduce 5


state 31
	expr : expr '+' expr .  (3)
	expr : expr . '+' expr
	expr : expr . '-' expr
	expr : expr . '*' expr
	expr : expr . '/' expr
	expr : expr . '%' expr

	'%'  shift 18
	'*'  shift 19
	'/'  shift 22
	.  reduce 3


state 32
	expr : expr . '+' expr
	expr : expr '-' expr .  (4)
	expr : expr . '-' expr
	expr : expr . '*' expr
	expr : expr . '/' expr
	expr : expr . '%' expr

	'%'  shift 18
	'*'  shift 19
	'/'  shift 22
	.  reduce 4


state 33
	expr : expr . '+' expr
	expr : expr . '-' expr
	expr : expr . '*' expr
	expr : expr '/' expr .  (6)
	expr : expr . '/' expr
	expr : expr . '%' expr

	.  reduce 6


state 34
	expr : SIN '(' expr ')' .  (11)

	.  reduce 11


state 35
	expr : COS '(' expr ')' .  (12)

	.  reduce 12


state 36
	expr : TAN '(' expr ')' .  (13)

	.  reduce 13


state 37
	expr : LOG '(' expr ')' .  (14)

	.  reduce 14


##############################################################################
# Summary
##############################################################################

17 token(s), 3 nonterminal(s)
15 grammar rule(s), 39 state(s)


##############################################################################
# End of File
##############################################################################
