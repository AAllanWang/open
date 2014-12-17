import math
count = int(raw_input())
sum = 0
flag =0
j = 0
for i in range(2,count):
	flag = 0
	for j in range(2,int(math.sqrt(i)) + 1):
		if i % j ==0:
			flag = 1
			break
	if flag == 0:
		sum += i

print sum		


