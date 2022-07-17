'''
The array is sorted.
If the mid element <= x, store and search further in (m+1,j)
else if element > x, search in (i,m-1)
'''

import sys
class Solution:
    #User function Template for python3
    
    #Complete this function
    def findFloor(self,a,N,x):
        #Your code here
        i = 0
        j = N-1
        ans = -1
        while i <= j:
            m = i + ((j-i)//2)
            if a[m] <= x:
                ans = max(ans, m)
                i = m + 1
            elif a[m] > x:
                j = m-1
        
        return ans
