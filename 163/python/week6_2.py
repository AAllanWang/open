
def pascar(num):
	lst = [1]
	for i in range(num):
		if i < num -1:
			print ' '*(num-i-2),
		for j in lst:
			print j,
		print 
		lst = [lst[k]+lst[k+1] for k in range(0,i)]
		lst.insert(0,1)
		lst.append(1)
		
n = int(raw_input())
pascar(n)