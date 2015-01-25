import math

def isLoopNum(n):
	strN = str(n)
	strNew = strN[::-1]
	if(strN == strNew):
		return True
	else:
		return False
		
deg = int(raw_input())

#lst = []
isOK = False
for i in range(int(math.pow(10,deg))-1,int(math.pow(10,deg))-int(math.pow(10,deg-1)),-1):
	for j in range(int(math.pow(10,deg))-1,int(math.pow(10,deg))-int(math.pow(10,deg-1)),-1):
		v = int(i*j)
		if isLoopNum(v):
			isOK = True
			print v
			break
	if isOK == True:
		break
#lst.sort(reverse=True)
#print lst[0]
			
