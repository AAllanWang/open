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
	deg = int(math.floor(math.log10(num))+1)
	for i in range(1,deg+1):
		t = math.pow(10,deg-i+1)
		left = int(n/t)	
		right = n % t
		new = right*math.pow(10,i)+left
		print "new num:",new
		if isPrim(new) == 0:
			ret = 0
			break
	return ret

num = int(raw_input())
print num
sum = 0
for a in range(2,num):
	if isPrim(a) == 1:
		if isLoopPrim(a) == 1:
			sum += 1
print sum	
