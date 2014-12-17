sum = 0
elapse = 0
leap = 0
dmax = 0
for y in range(1900,2001):
	leap = 0
	if (y%4==0 and y%100!=0) or y%400==0 :
		leap = 1
	for m in range(1,13):
		if m ==2 :
			if leap == 1:
				dmax = 29
			else:
				dmax = 28
		else:
			if m == 1 or m == 3 or m==5 or m==7 or m==8 or m==10 or m==12:
				dmax = 31
			else:
				if m==4 or m==6 or m==9 or m==11:
					dmax = 30
		if (elapse+1) % 7 ==0 and y > 1900:
			sum+=1
		elapse += dmax

print sum
