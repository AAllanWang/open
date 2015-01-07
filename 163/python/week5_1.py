#pig latin
def pigLatin(word):
	if(word[0] in ('a','e','i','o','u')):
		return word+'hay'
	elif(cmp(word[:2], 'qu')==0):
		return word[2:]+'quay'
	elif('aeiou'.find(word[0]) ==-1):
		if(len(word) == 1):
			return word+'ay'
		else:
			i = 0
			for j in range(1,len(word)):
				if('aeiouy'.find(word[j])!=-1):
					i = j
					break;
			return word[i:]+word[:i]+'ay'	


input = raw_input()
input = input.lower()
output = ''
for word in input.split(' '):
	if(len(word) > 0 and word.isalpha()):
		output += pigLatin(word)
		output +=' '

print output[:-1]
