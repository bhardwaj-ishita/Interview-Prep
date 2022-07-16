class Solution:

	def count(self,arr, n, x):
		def left():
		    start = 0
		    end = n-1
		    ans = -1
		while start <= end:
		    mid = (start + end)//2
		    if arr[mid] == x:
			ans = mid
			end = mid - 1
		elif arr[mid] > x:
		    end = mid - 1
		else:
		    start = mid + 1
	    return ans
            
		def right():        
		    start = 0
		    end = n  - 1  
		    ans = -1
		    while start <= end:
			    mid = (start + end)//2
			    if arr[mid] == x:
				ans = mid
				start = mid + 1
			elif arr[mid] > x:
			    end = mid - 1
			else:
			    start = mid + 1
		    return ans
        
        i = right()
        j = left()
        if i < 0 or j < 0:
            return 0
        return i - j + 1
