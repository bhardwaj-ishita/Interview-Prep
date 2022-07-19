# Search an element in the bitonic array
'''
The problem is divided into two problems
1. bitonic point
2. binary search ascending
3. binary search descending

As this is a bitonic array, we know (0, bitonic point) values are in ascending order
(bitonic point + 1, n-1) they are in descending order

So binary search both arrays to find the key.
If does not exist then, return -1
'''

class Solution:
  
  def sol(a, n, key):
    x = findMaximum(a,n)
    left = binarySearchAsc(a, 0, x-1, key)
    right = binarySearchDesc(a, x, n-1, key)
    return max(left,right)
  
  def binarySearchAsc(a, i, j, key):
    while i <= j:
      m = i + ((j-i)//2)
      if a[m] == key:
        return m
      elif a[m] > key:
        end = m - 1
      elif a[m] < key:
        start = m + 1
    return -1
  
  def binarySearchDesc(a, i, j, key):
    while i <= j:
      m = i + ((j-i)//2)
      if a[m] == key:
        return m
      elif a[m] < key:
        end = m - 1
      elif a[m] > key:
        start = m + 1
    return -1
  
	def findMaximum(a, n):
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
