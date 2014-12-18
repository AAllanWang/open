import math

def isPrim(n):
	ret = 1
	for i in range(2,int(math.sqrt(n))+1):
		if n % i ==0:
			ret = 0
			break
	return ret	

def isLoopPrim(n):
	ret = 1
	if isPrim(n) == 0:
		return 0
	deg = int(math.floor(math.log10(n))+1)
	if deg >1:
		for i in range(1,deg+1):
			t = math.pow(10,deg-i)
			left = int(n/t)
			if left % 2 == 0 or left %5 == 0:
				ret = 0	
				break
			right = int(n % t)
			new = int(right*math.pow(10,i)+left)
			if isPrim(new) == 0:
				ret = 0
				break
	return ret


num = int(raw_input())
sum = 0
for a in range(2,num):
	if isLoopPrim(a) == 1:
		sum += 1
print sum	
