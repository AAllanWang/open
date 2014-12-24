def IsLeapYear(y):
	if (y%4==0 and y%100!=0) or y%400==0 :
		return True
	else:
		return False

def DaysOfYear(y):
	if IsLeapYear(y):
		return 366
	else:
		return 365


def TheDayToMonthEnd(y,m):
	sum = 0 
	if m == 12:
		sum = DaysOfYear(y)
	else:
		for i in range(1,m+1):
			if i in (1,3,5,7,8,10,12):
				sum += 31
			else:
				if i in (4,6,9,11):
					sum += 30
				else:
					if i == 2:
						if IsLeapYear(y):
							sum += 29
						else:
							sum += 28
	return sum


def LeftDaysFromMonthEnd(y,m):
	return DaysOfYear(y) - TheDayToMonthEnd(y,m)


def WhatDayOfYearMonthEnd(y,m):
	s = 0
	ret = 0
	if y >= 1800:
		for i in range(1800,y):
			s += DaysOfYear(i)
		s += TheDayToMonthEnd(y,m)
		ret = (s+2)%7
	elif y < 1800:
		for i in range(y+1,1800):
			s += DaysOfYear(i)
		s += LeftDaysFromMonthEnd(y,m)
		ret = 6 - (s+4)%7
	return ret	
year = int(raw_input())
month = int(raw_input())


	
print WhatDayOfYearMonthEnd(year,month)
