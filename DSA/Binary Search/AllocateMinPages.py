#Find the min no. of max pages a student should read
'''
The question says, you have n books. m students. Sorted(even if it is unsorted, the question can be solved using binary search)
All the books should be divided between all students contiguously

So what we can do is search it in an array of all possible pages: i.e the max the student can take to the total a student can take
We'll make an array from max(ofArray) ------- sum(ofArray)
and start from mid 
We'll see if it is possible to give each student mid no. of pages, such that all pages are divided between m students
For example:
n = 4
a[] = 10 20 30 40 == 100 pages
m = 2

if mid == 75:
S1 = 10 + 20 + 30 + 40 ? N0 > 75
S1 = 10+20+30 = 60
S2 = 40

It is possible but we can do better

So mid = (40 + 74)/2 = 57
S1 = 10 + 20 = 30
S2 = 30
S3 = 40

It is false too
So we start = mid + 1

mid = (58 + 100)//2 == 79
S1 = 10 + 20 + 30
S2 = 40

This is true but we can do better
So mid = (58 + 78)//2 = 68
S1 = 10 + 20 + 30
S2 = 40

True but we can still do better
mid = (58 + 67)//2 = 62
True
but...

until mid == 60
S1 = 10 + 20 + 30

'''

class Solution:
  def findPages(self, a, n, m):
        #code here
        if m > n:
            return -1
        start = a[n-1]
        end = sum(a)
        ans = -1
        while start <= end:
            mid = start + ((end - start)//2) 
            if self.isValid(a,mid,m):
                ans = mid
                end = mid - 1
            else:
                start = mid + 1
        return ans
    
    
  def isValid(self,a,mid,m):
      student = 1
      sums = 0
      for i in a:
          sums = sums + i
          if sums > mid:
              student = student + 1
              sums = i
      if student <= m:
          return True
      return False
