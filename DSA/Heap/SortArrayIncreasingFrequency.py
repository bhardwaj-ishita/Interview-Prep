class Solution:
    def frequencySort(self, nums: List[int]) -> List[int]:
        
        #create frequency dictionary
        freq = {}
        for i in nums:
            if i in freq:
                freq[i] = freq[i] + 1
            else:
                freq[i] = 1
        
        #sort in decreasing freq order using heap(max heap)
        heap = []
        for i in freq:
            heapq.heappush(heap,[-1*freq[i],i])
        
        ans = []
        while heap:
            for i in range(1, -1*heap[0][0] + 1):
                ans.append(heap[0][1])
            heapq.heappop(heap)
            
        return ans[::-1]
