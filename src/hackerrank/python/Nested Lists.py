# Nested Lists
# https://www.hackerrank.com/challenges/nested-list/problem

students = []

for _ in range(int(raw_input())):
    name = raw_input()
    score = float(raw_input())
    s = [name, score]
    # print s
    students.append(s)
    
# print students

students.sort(key=lambda _: _[1])

# print students[1][0]
# print students

f = filter(lambda _: _[1] == students[1][1], students)
#print f

f.sort()
for _ in f:
    print _[0]