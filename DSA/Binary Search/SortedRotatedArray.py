#The base question is to find the index of the MinElement
#Q1. find the no. of rotations
#Q2. find the minElement

'''
we are given the arrray and we have to find the number of rotations
So if we know where the minimum number lies, that is the number of rotations done to it
So how do we find the index of the min element

We are given a sorted array which is rotated, so we will try binary search
now in bs, we need a target. Here the target is minElement
But we don't know what the minElement is. 
So how do we recognize the minElement?
if a[i] = mid,
then a[i-1] > a[i] < a[i+1] (condition for minElement)

Now if the condition is not satisfied, we have to either move to the right or left
If you see, either of the side will be sorted and the other will be unsorted.
The side which is unsorted is where we need to go.
How do you recognize a sorted and unsorted array?
the first element of the array is smaller than the last!

PS. In any case both the arrays are sorted, then the array has been rotated 0 times
Hence the binary search stuff is sorted.


This is also a tricky one

When we're given a sorted array, and idol time complexity as O(logn), it is probable that we have to use binary search

Now in binary search we are given:
target
sorted array
a condition for left and right array

In this question
target = minElement (but we don't know the minElement)
sorted array (but the array is rotated x times)
condition for left and right array(we need to find)

1. The question boils down to finding the index of the minimum element. That is also the number of times the sorted array has been rotated
2. a target is whenever prev of mid > mid AND next of mid > mid
3. if the condition fails then, we have to search either the right or the left array (not both). And how do we make that choice. Anywhere there is no order i.e. the side of the array that is not sorted (prev > mid < next) that is where the minElement is
4. Now a very important thing that nobody tells. There might be a point where both the left and right arrays are sorted. Then the minElement would be to the smaller side. So put the left array condition above so that it goes there. 

'''

class Solution:
    def findKRotation(self,arr,n):
        
        start = 0
        end = n-1
        
        while start <= end:
            
            mid = start+((end-start)//2)
            
            prev = (mid-1+n)%n
            after = (mid+1)%n
            ;
            if arr[mid] <= arr[prev] and arr[mid] <= arr[after]:
                return mid
            
            elif arr[mid] <= arr[end]:
                end = mid - 1
                
            elif arr[start] <= arr[mid]:
                start = mid + 1
                
        return 0
      


