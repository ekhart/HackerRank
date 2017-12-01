# Time Delta
# https://www.hackerrank.com/challenges/python-time-delta/problem


#!/bin/python

import sys
from datetime import datetime


def time_delta(t1, t2):
    print t1
    print t2
    
    format = '%a %d %b %Y %H:%M:%S %z'
    
    dt1 = datetime.strptime(t1, format)
    print dt1
    
    dt2 = datetime.strptime(t2, format)
    print dt2
    
    return dt2 - dt1

if __name__ == "__main__":
    t = int(raw_input().strip())
    for a0 in xrange(t):
        t1 = raw_input().strip()
        t2 = raw_input().strip()
        delta = time_delta(t1, t2)
        print delta