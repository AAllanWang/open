#! /usr/bin/python
import math
a = float(raw_input());
b = float(raw_input());
c = float(raw_input());

print "%.1f" % float(math.degrees(math.acos((a**2+b**2 -c**2)/(2*a*b))))
