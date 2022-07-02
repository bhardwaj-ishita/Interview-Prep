import heapq
class Solution:
    def printKClosest(self, arr, n, k, x):
        # code here
        
        
            
        heap = []
        for i in arr:
            if abs(i-x) is 0:
                continue
            heapq.heappush(heap,[-1*abs(i - x),i])
            if len(heap) > k:
                heapq.heappop(heap)
            
        ans = []
        while heap:
            ans.append(heapq.heappop(heap)[1])
        return ans[::-1]
