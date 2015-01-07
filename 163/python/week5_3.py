
def getSum(word):
	sum = 0
	for w in word.upper():
		if ord(w) >= ord('A') and ord(w) <= ord('Z'):
			sum += (ord(w) - ord('A') +1)
			
	return sum

input = raw_input()
while input != '':
	print getSum(input)
	input = raw_input()
