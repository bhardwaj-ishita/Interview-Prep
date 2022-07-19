'''
Find the bitonic point
And if it doesn't exist return the greatest element

condition 1: m-1 < m > m + 1
condition 2: m - 1 > m: end = m - 1
condition 3: m < m + 1: start = m + 1

And as at a time we are considering 3 indices. The min array we can look into is length = 3
If lenght = 1: return a[0]
if length = 2: return max(a[0],a[1])
for lenght >= 3: use the conditions
'''


class Solution:

	def findMaximum(self,a, n):
		# code here
		if n == 1:
		    return a[0]
		    
		
		start = 1
		end = n-2
		while start <= end:
		    m = start + ((end - start)//2)
		    
		    if a[m-1] < a[m] and a[m] > a[m+1]:
		        return a[m]
	        elif a[m-1] > a[m]:
	            end = m - 1
            elif a[m+1] > a[m]:
                start = m + 1
            
        return max(a[start],a[end])   
