import math
def isPrime(n):
	ret = True
	for i in range(2,int(math.sqrt(n))+1):
		if n % i ==0:
			ret = False
			break
	return ret	

def prime(n):
	ret = []
	for i in range(2,n):
		if isPrime(i):
			ret.append(i)
	return ret
	
def bi_search(num,lst,low,high):
	if low > high:
		return -1
	index = int((low+high)/2)
	if lst[index] == num:
		return index
	elif lst[index] > num:
		return bi_search(num,lst,low,high - 1)
	else:
		return bi_search(num,lst,low+1,high)
	
input = int(raw_input())
lst_prime = prime(input)
num = raw_input()
while num != '':
	print bi_search(int(num),lst_prime,0,len(lst_prime)-1)
	num = raw_input()