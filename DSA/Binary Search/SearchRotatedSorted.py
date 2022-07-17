'''
Find the minimum element index
And Binary search in array (0,x-1) and (x,n-1)
either both will return -1 i.e. the element does not exist
or one of them will return -1 and other the index of the element, return that
'''

class Solution:
    def search(self, a : list, l : int, h : int, key : int):
        # l: The starting index
        # h: The ending index, you have to search the key in this range
        # Complete this function
        def BS():
            n = len(a)
            start = 0
            end = n-1
            
            while start <= end:
                mid = start+((end-start)//2)
                prev = (mid-1+n)%n
                after = (mid+1)%n
                if a[mid] <= a[prev] and a[mid] <= a[after]:
                    return mid
                elif a[mid] <= a[end]:
                    end = mid - 1
                elif a[start] <= a[mid]:
                    start = mid + 1
            return 0
            
        def binarySearch(i,j):
            while i <= j:
                mid = (i + j)//2
                if a[mid] == key:
                    return mid
                elif a[mid] > key:
                    j = mid - 1
                else:
                    i = mid + 1
            return -1
                    
        
            
        x = BS()
        right,left = -1,-1
        if x>0:
            left = binarySearch(0,x)
        right = binarySearch(x,h)
        if left <= right < 0:
            return  -1
        elif right >= 0:
            return right
        return left
