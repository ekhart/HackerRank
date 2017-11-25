# Symmetric Difference
# https://www.hackerrank.com/challenges/symmetric-difference/problem

# Enter your code here. Read input from STDIN. # print output to STDOUT
line = raw_input()
# print line

line = raw_input()
# print line

m = set(map(int, line.split()))
# print m

line = raw_input()
# print line

line = raw_input()
# print line

n = set(map(int, line.split()))
# print n

mndiff = m.difference(n)
# print mndiff

nmdiff = n.difference(m)
# print nmdiff

sym_diff = mndiff.update(nmdiff)
# print sym_diff # zwraca None?

sym_diff = mndiff
for _ in nmdiff:
  sym_diff.add(_)
s = list(sym_diff)
# print s
s.sort()
# print s

def prn(x): print x
    
map(prn, s)
# for _ in s:
#  # print s