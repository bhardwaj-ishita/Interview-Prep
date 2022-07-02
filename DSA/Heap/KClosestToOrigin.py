#Quickselect Implementation: Optimized
import math
class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        
        # quickselect implementation
        # in quicksort the array is sorted around the pivot
        # whereas in quickselect you select the kth value i.e the pivot as the answer
        
        def partition(l,r,pivot_index):
            pivot = distances[pivot_index]
            
            #send the pivot to the end
            distances[r], distances[pivot_index] = distances[pivot_index], distances[r]
            points[r], points[pivot_index] = points[pivot_index],points[r]
            
            # [array],pivot
            # we'll be traversing the array 
            # and put the values left if smaller and right if larger than pivot
            # and at the end interchange the pivot index and point where the smaller values have been exchanged
            
            store_index = l
            for i in range(l,r):
                if distances[i] < pivot:
                    distances[i], distances[store_index] = distances[store_index], distances[i]
                    points[i], points[store_index] = points[store_index], points[i]
                    store_index = store_index + 1
                    
            distances[r], distances[store_index] = distances[store_index], distances[r]
            points[r], points[store_index] = points[store_index], points[r]
            return store_index
        
        
        
        def select(l,r,k):
            if (l<r):
                pivot_index = int((l+r)/2)
                pivot_index = partition(l,r,pivot_index)
                
                if pivot_index == k:
                    return
                if pivot_index < k:
                    select(pivot_index+1,r,k)
                else:
                    select(l, pivot_index-1,k)
            
        distances = [(x**2 + y**2) for x,y in points]    
        select(0,len(points)-1, k)
        return points[:k]
      
      
      
#Heap
import math
class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        # find the distance from the origin to the coordinates
        # we'll find the top k coordinates according to the distance by using max heap
        # return all the top k coordinates
        # we can't use dictionary to save pairs as the key
        # so the heap approach will decrease time complexity from O(nlogn) to O(nlogk)
        
        
        heap = []
        for j in points:
            d = j[0]**2 + j[1]**2
            heapq.heappush(heap, [-d,j])
            if len(heap) > k:
                heapq.heappop(heap)
            
        ans = []
        while heap:
            ans.append(heapq.heappop(heap)[1])
        
        return ans
