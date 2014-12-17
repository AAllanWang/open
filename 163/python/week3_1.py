#! /usr/bin/python

count = int(raw_input())
sum = 0
for i in range(1,count):
	if i % 3 == 0 or i % 5 ==0:
		sum += i
print sum		

