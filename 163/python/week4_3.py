def Move(frm, to, num):
	print "Move",num,"from",frm,"to",to


def Hanoi(A,B,C,n):
	if n == 1:
		Move(A,C,n)
		return
	else:
		Hanoi(A,C,B,n-1)
		Move(A,C,n)
		Hanoi(B,A,C,n-1)

number = int(raw_input())
Hanoi("A","B","C",number)
