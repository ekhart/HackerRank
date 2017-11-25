# Calendar Module
# https://www.hackerrank.com/challenges/calendar-module/problem
# https://docs.python.org/2/library/calendar.html#calendar.weekheader

# Enter your code here. Read input from STDIN. Print output to STDOUT

import calendar

line = raw_input()
# print line
s = line.split()
# print s
i = map(int, s)
# print i
c = calendar.weekday(i[2], i[1] - 1, i[0])
# print c
# print calendar.day_name
print calendar.day_name[c].upper()