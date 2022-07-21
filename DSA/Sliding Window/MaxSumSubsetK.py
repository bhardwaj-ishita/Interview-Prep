class Solution:
    def maximumSumSubarray (self,k,a,n):
        # code here 
        if k == n:
            return sum(a)
        
        prevSum, currSum, maxSum = 0,0,0
        
        #created the window
        for i in range(k):
            prevSum += a[i]
        
        #till now the maxSum of window size k is prevSum itself
        maxSum = prevSum
        
        #sliding window starts here
        #here we made pointers at indices we need to add and subtrace from prevSum
        #we store that new sum in currSum
        #max of currSum and total maxSum is maxSum
        #Next we update the prevSum and i, j pointers too
        i,j = 0,k
        while j < n:
            currSum = prevSum + a[j] - a[i]
            maxSum = max(maxSum,currSum)
            prevSum = currSum
            j += 1
            i += 1
            
        return maxSum
      
#------------------------------------------------------------
class Solution:
    def maximumSumSubarray (self,k,a,n):
        # code here 
        if k == n:
            return sum(a)
        
        currSum, maxSum = 0,0
        
        #Here we initiated from the starte
        #If the window size is less than keep incrementing the j pointer
        #The moment the size == k, store it(maximum sum) and add jth index and remove ith index
        #By doing this the window is still of size k but has moved forward by one step
        i,j = 0,0
        while j < n:
            currSum += a[j]
            if j - i + 1 == k:
                maxSum = max(maxSum,currSum)
                currSum -= a[i]
                i += 1
            j += 1
            
        return maxSum
