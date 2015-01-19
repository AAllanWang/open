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
# ExpressionLexer.v
# Lex verbose file generated from ExpressionLexer.l.
# 
# Date: 01/19/15
# Time: 15:11:50
# 
# ALex Version: 2.07
#############################################################################


#############################################################################
# Expressions
#############################################################################

    1  [0-9]+"."[0-9]*([Ee][+-]?[0-9]+)?

    2  "."[0-9]+([Ee][+-]?[0-9]+)?

    3  [0-9]+([Ee][+-]?[0-9]+)?

    4  "sin"

    5  "cos"

    6  "tan"

    7  "log"

    8  "="

    9  "+"

   10  "-"

   11  "*"

   12  "/"

   13  "%"

   14  "("

   15  ")"

   16  \r?\n

   17  [ \t]

   18  .


#############################################################################
# States
#############################################################################

state 1
	INITIAL

	0x0000 - 0x0008 (9)      goto 3
	0x0009                   goto 4
	0x000a                   goto 5
	0x000b - 0x000c (2)      goto 3
	0x000d                   goto 6
	0x000e - 0x001f (18)     goto 3
	0x0020                   goto 4
	0x0021 - 0x0024 (4)      goto 3
	0x0025                   goto 7
	0x0026 - 0x0027 (2)      goto 3
	0x0028                   goto 8
	0x0029                   goto 9
	0x002a                   goto 10
	0x002b                   goto 11
	0x002c                   goto 3
	0x002d                   goto 12
	0x002e                   goto 13
	0x002f                   goto 14
	0x0030 - 0x0039 (10)     goto 15
	0x003a - 0x003c (3)      goto 3
	0x003d                   goto 16
	0x003e - 0x0062 (37)     goto 3
	0x0063                   goto 17
	0x0064 - 0x006b (8)      goto 3
	0x006c                   goto 18
	0x006d - 0x0072 (6)      goto 3
	0x0073                   goto 19
	0x0074                   goto 20
	0x0075 - 0xffff (65419)  goto 3


state 2
	^INITIAL

	0x0000 - 0x0008 (9)      goto 3
	0x0009                   goto 4
	0x000a                   goto 5
	0x000b - 0x000c (2)      goto 3
	0x000d                   goto 6
	0x000e - 0x001f (18)     goto 3
	0x0020                   goto 4
	0x0021 - 0x0024 (4)      goto 3
	0x0025                   goto 7
	0x0026 - 0x0027 (2)      goto 3
	0x0028                   goto 8
	0x0029                   goto 9
	0x002a                   goto 10
	0x002b                   goto 11
	0x002c                   goto 3
	0x002d                   goto 12
	0x002e                   goto 13
	0x002f                   goto 14
	0x0030 - 0x0039 (10)     goto 15
	0x003a - 0x003c (3)      goto 3
	0x003d                   goto 16
	0x003e - 0x0062 (37)     goto 3
	0x0063                   goto 17
	0x0064 - 0x006b (8)      goto 3
	0x006c                   goto 18
	0x006d - 0x0072 (6)      goto 3
	0x0073                   goto 19
	0x0074                   goto 20
	0x0075 - 0xffff (65419)  goto 3


state 3
	match 18


state 4
	match 17


state 5
	match 16


state 6
	0x000a                   goto 5

	match 18


state 7
	match 13


state 8
	match 14


state 9
	match 15


state 10
	match 11


state 11
	match 9


state 12
	match 10


state 13
	0x0030 - 0x0039 (10)     goto 21

	match 18


state 14
	match 12


state 15
	0x002e                   goto 22
	0x0030 - 0x0039 (10)     goto 15
	0x0045                   goto 23
	0x0065                   goto 23

	match 3


state 16
	match 8


state 17
	0x006f                   goto 24

	match 18


state 18
	0x006f                   goto 25

	match 18


state 19
	0x0069                   goto 26

	match 18


state 20
	0x0061                   goto 27

	match 18


state 21
	0x0030 - 0x0039 (10)     goto 21
	0x0045                   goto 28
	0x0065                   goto 28

	match 2


state 22
	0x0030 - 0x0039 (10)     goto 22
	0x0045                   goto 29
	0x0065                   goto 29

	match 1


state 23
	0x002b                   goto 30
	0x002d                   goto 30
	0x0030 - 0x0039 (10)     goto 31


state 24
	0x0073                   goto 32


state 25
	0x0067                   goto 33


state 26
	0x006e                   goto 34


state 27
	0x006e                   goto 35


state 28
	0x002b                   goto 36
	0x002d                   goto 36
	0x0030 - 0x0039 (10)     goto 37


state 29
	0x002b                   goto 38
	0x002d                   goto 38
	0x0030 - 0x0039 (10)     goto 39


state 30
	0x0030 - 0x0039 (10)     goto 31


state 31
	0x0030 - 0x0039 (10)     goto 31

	match 3


state 32
	match 5


state 33
	match 7


state 34
	match 4


state 35
	match 6


state 36
	0x0030 - 0x0039 (10)     goto 37


state 37
	0x0030 - 0x0039 (10)     goto 37

	match 2


state 38
	0x0030 - 0x0039 (10)     goto 39


state 39
	0x0030 - 0x0039 (10)     goto 39

	match 1


#############################################################################
# Summary
#############################################################################

1 start state(s)
18 expression(s), 39 state(s)


#############################################################################
# End of File
#############################################################################
