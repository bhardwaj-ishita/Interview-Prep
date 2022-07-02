import heapq
class Solution:
    def sumBetweenTwoKth(self, A, N, K1, K2):
        # Your code goes here
        
        heap = []
        #we can take a min heap and remove all elements smaller than K1st element
        #or we can take max heap and remove all elements larger than K2nd element
        
        #min heap
        for i in range(N):
            heapq.heappush(heap,A[i])
            
            if len(heap) > (N-K1):
                heapq.heappop(heap)
        
        add = 0
        for i in range(1,K2-K1):
            add = add + heapq.heappop(heap)
            
        return add
