class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        #find the frequencies
        freq  = {}
        for i in nums:
            if i in freq.keys():
                freq[i] = freq[i] + 1
            else:
                freq[i] = 1
        
        
        #use heap to find the top k frequencies
        heap = []
        for i in freq:
            heapq.heappush(heap,[freq[i],i])
            if len(heap) > k:
                heapq.heappop(heap)
        
        
        
        ans = []
        while heap:
            ans.append(heapq.heappop(heap)[1])
            
        return ans[::-1]
