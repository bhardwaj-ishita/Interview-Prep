import heapq
class Solution:
    #Function to return the minimum cost of connecting the ropes.
    def minCost(self,arr,n) :
    
        # code here
        # push all the values in the min heap
        # pop two values -> add them -> push it back in the heap
        # do it till len(heap) == 1
        # that is the answer
        
        heap = []
        for i in arr:
            heapq.heappush(heap,i)
        
        cost = 0
        while len(heap) != 1:
            i = heapq.heappop(heap)
            j = heapq.heappop(heap)
            cost = cost + (i+j)
            heapq.heappush(heap,i+j)
            
        return cost
