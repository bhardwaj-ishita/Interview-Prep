class Solution:
    
    #Function to return the sorted array.
    def nearlySorted(self,a,n,k):
        
        # code here
        heap = []
        sol = []
        for i in a:
            heapq.heappush(heap,i)
            if len(heap) > k:
                sol.append(heapq.heappop(heap))
                
            
        while heap:
            sol.append(heapq.heappop(heap))
            
        return sol
