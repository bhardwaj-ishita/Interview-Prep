import heapq
def getMaximumAmount(quantity, m):
  n = len(quantity)
  heap = []
  ans = 0
  for i in range(n):
    heapq.heappush(heap,-1*quantity[i])
    
  while m > 0:
    m-=1
    x = -1*heapq.heappop(heap)
    ans += x
    heapq.heappush(heap,-1*(x-1))
    
 return ans
    
