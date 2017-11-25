# Symmetric Difference
# https://www.hackerrank.com/challenges/symmetric-difference/problem

line = raw_input()
line = raw_input()
m = set(map(int, line.split()))
line = raw_input()
line = raw_input()
n = set(map(int, line.split()))
mndiff = m.difference(n)
nmdiff = n.difference(m)
sym_diff = mndiff.update(nmdiff)

sym_diff = mndiff
for _ in nmdiff:
  sym_diff.add(_)

s = list(sym_diff)
s.sort()

def prn(x): print x
    
map(prn, s)
