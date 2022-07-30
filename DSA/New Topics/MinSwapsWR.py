#Minimum number of adjacent swaps of a string of Ws and Rs

def solution(S):
  n = len(S)
  countOfR = 0
  
  for i in S:
    if i == 'R':
      countOfR += 1
      
  if countOfR == 0:
    return 0
  
  i,j = 0,0
  length = sys.maxsize
  
  while j < n:
    if S[j] == 'R':
      curr += 1
      
    if curr == countOfR:
      length = min(lenght,j-i+1)
      while i < j and S[i] != 'R':
        i+=1
        if curr == countOfR:
          length = min(length,j-i+1)
    j+=1
    
  ans = length - countOfR
  if ans >= 99999:
    return -1
  return ans
