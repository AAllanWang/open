
InvertedDict = {}

#create index
for line_num in range(1,101):
	line_str = raw_input()
	line_list = line_str.strip().split(' ')
	for word in line_list:
		if len(word.strip()) > 0:
			if word in InvertedDict:
				if line_num not in InvertedDict[word]:
					InvertedDict[word].append(line_num)
			else:
				InvertedDict[word] = [line_num]
		
		
#print index
kv_list = []
for k,v in InvertedDict.items():
	kv_list.append((k,v))
kv_list.sort()
for k,v in kv_list:
	print str(k)+":",", ".join([str(elem) for elem in v])
	
#query
line_keywords = raw_input()
while line_keywords != '':
	ret = []
	i = line_keywords.find('OR:')
	if i != -1:
		keywords = line_keywords[3:]
		kw_list = keywords.strip().split(' ')
		if len(kw.strip()) > 0:
			for kw in kw_list:
				if kw in InvertedDict:
					ret = list(set(ret)| set(InvertedDict[kw]))
	else:
		i = line_keywords.find('AND:')
		if i != -1:
			keywords = line_keywords[4:]
		else:
			keywords = line_keywords
		kw_list = keywords.strip().split(' ')
		for kw in kw_list:
			if len(kw.strip()) > 0:
				if kw in InvertedDict:
					if len(ret) == 0:
						ret = InvertedDict[kw]
					else:
						ret = list(set(ret) & set(InvertedDict[kw]))
				else:
					ret = []
					break
	if len(ret) == 0:
		print 'None'
	else:
		ret.sort()
		print ', '.join([str(elem) for elem in ret])
	line_keywords = raw_input()

	
