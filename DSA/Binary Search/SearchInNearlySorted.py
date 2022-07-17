#Nearly Sorted means that Every ith element is either at i-1, i or i + 1 position
# Find the element
class Solution:
   
    def search(self,a,x):
        #Your code here
        n = len(a)
        i = 0
        j = n-1

        while i <= j:
            m = i + ((j-i)//2)
            if a[m] == x:
              return m
            if m-1 >= 0 and a[m-1] == x:
              return m-1
            if m + 1 < n and a[m+1] == x:
              return m + 1
            elif a[m] > x:
              j = m-2
            elif a[m] < x:
              i = m + 2
        
        return -1
