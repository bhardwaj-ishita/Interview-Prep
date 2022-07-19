'''
What's special here is that, all those traditional three conditions have been adapted according to the criteria

a[m] == key ---------> a[m-1] > a[m] < a[m+1]   #mid
a[m] > key -------------> a[m-1] > a[m]       #left
a[m] < key --------------> a[m+1] > a[m]          #right

and this is only possible because there are multiple peaks. If not, then BS would've been difficult

Base Conditions
if n==1: return 0
if a[0] > a[1]: return 0
if a[n-1] > a[n-2]: return n-1
'''

class Solution:
    def findPeakElement(self, a: List[int]) -> int:
        n = len(a)
        
        if n == 1:
            return 0
        if a[0] > a[1]:
            return 0
        if a[n-1] > a[n-2]:
            return n-1
        
        
        start = 1
        end = n-2
        while start <= end:
            m = start + ((end-start)//2) 
            if a[m+1] < a[m] and a[m] > a[m-1]:
                return m
            elif a[m+1] > a[m]:
                start = m + 1
            elif a[m-1] > a[m]:
                end = m - 1
            
        return -1
