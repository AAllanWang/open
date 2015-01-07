import keyword
import re

def isValidVar(var):
	pattern = re.compile(r'^[A-Za-z_]+\w*')
	if keyword.iskeyword(var):
		return False
	else:
		if pattern.match(var):
			return True
		else:
			return False


input = raw_input()
while input != "":
	print isValidVar(input)
	input = raw_input()

