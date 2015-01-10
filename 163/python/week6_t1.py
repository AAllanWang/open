def func(lst):
	for i in range(len(lst)-1):
		for j in range(i+1,len(lst)):
			if lst[i] < lst[j]:
				lst.insert(i,lst.pop(j))
			else:
				pass
	else:
		return lst
	return -1

lst1 = [6,2,4,1,5,9]
lst2 = func(lst1)
print lst2[3:-2]
lst2[3:-2] = []
print lst2
print lst1
