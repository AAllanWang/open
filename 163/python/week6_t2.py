
def Ann(lst):
	if len(lst) == 1:
		return [lst[:]]
	else:
		tmp = Ann(lst[1:])
		ret = []
		for item in tmp:
			for i in range(len(item)+1):
				tmp_item = item[:]
				tmp_item.insert(i,lst[0])
				ret.append(tmp_item[:])
		return ret
		

def Cnk(lst,k):
	if len(lst) < k or k <= 0:
		return []
	elif len(lst) == k:
		return [lst[:]]
	elif k == 1:
		ret = []
		for item in lst:
			tmp_item = [item]
			ret.append(tmp_item[:])
		return ret
	else:
		ret = []
		for i in range(len(lst)):
			tmp_lst = lst[:]
			elem = tmp_lst[i]
			del tmp_lst[i]
			tmp_ret = Cnk(tmp_lst,k-1)
			for tmp_ret_item in tmp_ret:
				tmp_ret_elem = tmp_ret_item[:]
				tmp_ret_elem.append(elem)
				ret.append(tmp_ret_elem)
		return ret
			
op = ['+','-','*','/','**']
oprand = ['2','3','4','5']

#r = Ann(l)
all_op = Cnk(op,3)
all_oprand = Ann(oprand)

for item_all_op in all_op:
	all_item_all_op = Ann(item_all_op)
	for elem_op in all_item_all_op:
		for elem_oprand in all_oprand:
			
			ret_str = elem_oprand[0]+elem_op[0]+elem_oprand[1]+elem_op[1]+elem_oprand[2]+elem_op[2]+elem_oprand[3]
			if eval(ret_str) == 28:
				print ret_str,"= 28"
				
			
		

#print all_oprand


#print r
#print len(r)