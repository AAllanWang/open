#! /usr/bin/python

num = int(raw_input());
h = num / 3600;
m = (num - 3600 * h)/60;
s = num - 3600*h - 60 *m;
print h,m,s;
