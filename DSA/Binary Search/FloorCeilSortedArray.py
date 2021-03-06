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
        while i <= j:
            m = i + ((j-i)//2)
            if a[m] <= x:
                i = m + 1
            elif a[m] > x:
                j = m-1
        
        return a[j]
    #You'll notice here that we return starting index. This is because when you run normal BS, when the condition i <= j fails, i points towards the greater neighbour
    #Simila is the case for j, jth index points towards the smaller neighbour. This is when the key/target is not present
    
    
#Ceil of the element given in sorted array
import sys
class Solution:
    def findCeil(self,a,N,x):
        #Your code here
        i = 0
        j = N-1
        ans = sys.maxsize
        while i <= j:
            m = i + ((j-i)//2)
            if a[m] >= x:
                ans = min(ans, m)
                j = m - 1
            elif a[m] < x:
                i = m+1
        
        if ans == sys.maxsize:
            return -1
        return ans

