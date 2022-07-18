#A sorted array is given, and a key is given
#Find the Element in the array which gives the min Absolute Diference with the key
#The ans will be the element closest to the key
#If key is given then, the key is the answer
#If key is not given then, the smallest of all the greatest number
#Or the largest of all smallest numbers to the key will be the answer

#Basically the Floor and Ceil of the target will be the answer
#Method 1: find the Floor and ceil and see which gives the min absolute difference
#Method 2: Apply same, plain and simple binary search. The moment start <= end condition comes false, what happens is start == at Ceil of target and end == at Floor of the target

class Solution:
    def search(self, a, key):
        n = len(a)
        start = 0
        end = n-1
        while start <= end:
          m = start + ((end - start)//2)
          if a[m] == key:
            return a[m]
          elif a[m] > key:
            end = m - 1
          elif a[m] < key:
            start = m + 1
        
        ceil = a[start] - key
        floor = key - a[end]
        if floor < ceil:
          return a[end]
        return a[start]
      
      
