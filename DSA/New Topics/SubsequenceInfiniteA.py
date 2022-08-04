'''
Given two strings a and b
Find if b exist as a subsequence in a`
where a` = pow(10,250) times a

For eg:
a = contest
b = son

a` = contestcontestcontest....
Return the ith index where we finish the b subsequence
Here ans = 10
a` = conte(StcON)testcontest....
N is at 10th position

NEED TO FIND OPTIMIZATION
'''
def solution(a,b):
  m = len(a)
  n = len(b)
  
  if m == 0 or n == 0:
    return 0
  
  for x in b:
    if x not in a:
      return -1
    
  i,j,count = 0,0,0
  length = n
  
  while i < m and j < n:
    if a[i] == b[j]:
      length -= 1
      if length == 0:
        break
      j += 1
      
     i+= 1
    
     if i == m:
        count += 1
        i = i%m
        if count == pow(10,250):
          return -1
        
    return (i + 1) + (count*m)
        
