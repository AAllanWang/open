
for i in range(10,100):
	if i/10 == i%10:
		for j in range(100,1000):
			if j/100 == j%10:
				k = i+j
				if k/1000 > 0 and k/1000 == k%10 and (k/100)%10 == (k/10)%10:
					print i,j,k
		