dictWord = {}

def toKey(strWord):
	lst=[]
	for c in strWord:
		lst.append(c)
	lst.sort()
	return ''.join(lst)
	
def addToDict(strWord):
	key = toKey(strWord)
	if key in dictWord:
		dictWord[key].append(strWord)
	else:
		dictWord[key] = [strWord]
	

word = raw_input()
while word != '':
	addToDict(str(word))
	word = raw_input()

#print dictWord
len2keyDict = {}
sortvDict = {}
lenLst =[]

for k,v in dictWord.items():
	v.sort()
	sortvDict[k] = v
	lenLst.append(len(v))
	if len(v) in len2keyDict:
		len2keyDict[len(v)].append(k)
	else:
		len2keyDict[len(v)] = [k]
lenLst = list(set(lenLst))
lenLst.sort(reverse = True)

for i in lenLst:
	len2keyDict[i].sort(key = lambda item: sortvDict[item][0],reverse = True)
	for k in len2keyDict[i]:
		print ' '.join(sortvDict[k])