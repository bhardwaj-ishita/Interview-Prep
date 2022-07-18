#Find the first 1 in the Binary Infinite Sorted Array
#Combination of Infinite Sorted Array + First Occurence BS

class Solution:
    def search(self, a):
      start = 0
      end = 1
      while a[end] == 0:
        end = end * 2
        start = end
      
      ans = 0
      while start<=end:
        m = start + ((end - start)//2)
        if a[m] == 1:
          ans = m
          end = m - 1
        else:
          start = m + 1
       
      return ans
        
