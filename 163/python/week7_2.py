import codecs
import sys 

UTF8Writer = codecs.getwriter('utf8')
sys.stdout = UTF8Writer(sys.stdout)
UTF8Reader = codecs.getreader('utf8')
sys.stdin = UTF8Reader(sys.stdin)


def RightDeepQuery(string,frm,to,keywords,ret):
	if frm <= to and len(string[frm:to]) > 0:
		if string[frm:to] in keywords:
			ret.insert(0,string[frm:to])
			RightDeepQuery(string,0,to-len(string[frm:to]),keywords,ret)
		else:
			if len(string[frm:to]) == 1:
				ret.insert(0,string[frm:to])
				RightDeepQuery(string,0,to-1,keywords,ret)
			else:
				RightDeepQuery(string,frm+1,to,keywords,ret)
				

line = raw_input()
keywords = line.strip().split()

sentence = raw_input()
while sentence != '':
	left = sentence.strip()
	ret = []
	RightDeepQuery(left,0,len(left),keywords,ret)
	for elem in ret:
		print elem,
	print
	sentence = raw_input()
