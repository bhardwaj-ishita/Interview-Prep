'''
This is some questions bro!

So we start with the basic optimization that we use a sliding window algo
Because we are calculating the max for a same range of the array again and again

Instead we use sliding window
Now what we can do is 
if the window is less than k:
	keep increasing the window and each time store the max values.
	maxVal = max(maxVal,a[j])
if the window == k:
	ans.append(maxVal)
	And if the maxVal == a[i] i.e. the ith array we are removing from the window
	then set the maxVal value again.
This time when the jth index comes, we'll have to set the maxVal = max( range(i,j-1), a[j]) because we have thrown out the maxVal we were using as far. So set a new maxVal
So we have to find the max out of all the elements in the window and the jth element.


Now to solve this problem, we definitely need some data structure that will hold the maxVal
So if the maxVal itself gets popped, we get the next maxVal from the ith index to j-1th index.

That is keep adding values from the back and keep popping the not required ith index from the front ---> use a queue

Now for example
i = 0 and j = 0
a= [1,3,1,2,0,5]

queue = [1, 3...
now 3 > 1 and is at later index. here 1 will not be required in the further calculations because the moment we pop 1, 3 will still be there and it will be the maxVal. There is no test case where 1 will ever become maxVal in presence of 3

so 
queue = [3,1...
Now here this 1 is requied to be stored because, the moment 3 gets popped there is a chance that 1 is the maxVal in that moment.

queue = [3,1,2... remove 1

Here we first we compared 0 < 5
and then we removed and compared 2 < 5
So use a while a[j] > queue[-1]: queue.pop()
queue = [3,2,0,5 remove 0
queue = [3,5] remove 2

'''


import sys
class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        #basic variables required
        n = len(nums)
        i,j = 0,0
        ans = []
        q = []
        minval = (-1*sys.maxsize) - 1
        maxVal = minval
        
        #start the sliding window algo
        while j < n:
          
            #calculation
            #how the values are getting pushed in the queue
            #1. if the jth element is greater than the right element keep popping
            while q and nums[j] > q[-1]:
                q.pop()
             
            #2.if after the while loop the queue gets empty, add the jth value because it is max
              #or else if finally a right came that was > nums[j], then just add the jth value because it might come in handy later when ith index gets removed
            if not q or (q and nums[j] <= q[-1]):
                q.append(nums[j])
            
            #every time we set the maxVal
            maxVal = max(maxVal,nums[j])
            
            #when we get the required widow size
            if (j-i+1) == k:
              
                #ans calculation
                ans.append(maxVal)
                
                #removing the values that are not required 
                #3. if maxVal itself is getting removed i.e it is at the top of queue i.e it is the maxVal
                  #we set the queue to the new window 
                  #we update the maxVal value
                if nums[i] == q[0]:
                    q.pop(0)
                if maxVal == nums[i]:
                    if q:
                        maxVal = q[0]
                    else:
                        maxVal = minval
                i += 1
                
            j += 1
            
        return ans
