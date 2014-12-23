def fibEvenSum(maxNum):
	sum = 0
	f1,f2 = 0,1
	while f2 < maxNum:
		if f2 % 2 ==0:
			sum += f2
		f1,f2 = f2,f1+f2
	return sum
	
max = int(raw_input())
print fibEvenSum(max)
