import sys
class Solution:
    ##Complete this function
    #Function to find the sum of contiguous subarray with maximum sum.
    def maxSubArraySum(self,arr,N):
        ##Your code here
        currSum, maxSum = 0,-1*sys.maxsize
        i = 0
        while i < N:
            currSum += arr[i]
            if currSum > maxSum:
                maxSum = currSum
            if currSum < 0:
                currSum = 0
                
            i+=1
        return maxSum
