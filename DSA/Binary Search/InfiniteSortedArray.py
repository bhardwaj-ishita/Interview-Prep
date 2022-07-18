# Search in an infinite sorted array i.e. don't know len(array)
'''
The concept is that find a finite sub array in the infinite index such that the key exists in that array
log n works in binary search when we keep dividing the array in half, and check only one half
Here we keep doubling the array size starting from one
'''

class Solution:
    def search(self, a, target):
      start = 0
      end = 1
      
      #the moment we find the ideal array for Binary Search, the loop breaks
      while target > a[end]:
        if a[end] == target:
          return end
        else:
          end = end * 2
          start = end

      while start <= end:
        m = start + ((end - start)//2)
        if a[m] == target:
          return m:
        elif a[m] > target:
          end = m - 1
        elif a[m] < target:
          start = m + 1
          
      return -1
        
      
        
