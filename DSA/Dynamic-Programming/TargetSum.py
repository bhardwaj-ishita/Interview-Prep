#Memoization
class Solution:
  
  
  #Remember the size of the array is put as 2*total
  #This is the offset. 
  #During the calculation the sum might become negetive and create a runtime error when dp[N][sum]
  #the sum has a range -total < sum < +total
  # sum = 2*total
  #here total is the offset to prevent the runtime error
    
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        total = sum(nums)
        dp = [[None for i in range(2*total + 1)] for j in range(len(nums)+1)]
        return self.rec(nums,0,0,total,target,dp)
    
    
    def rec(self,nums,N,S,total,target,dp):
        if N==len(nums):
            if S == target:
                return 1
            else:
                return 0
            
        if dp[N][S+total] != None:
            return dp[N][S+total]
        
        inc = self.rec(nums,N+1,S+nums[N],total,target,dp)  
        dec = self.rec(nums,N+1,S-nums[N],total,target,dp)
        dp[N][S+total] = inc + dec
        return dp[N][S+total]
      
      
#Tabular
class Solution:
    
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        total = sum(nums)
        N = len(nums)
        
        if (total < target) or (total + target)< 0 or  (total  + target) %2 != 0:
            return 0
        
        S = (target + total)//2
        dp = [[0 for i in range(S+1)] for j in range(N+1)]
        
        #initialization
        for i in range(S+1):
            dp[0][i] = 0
        for j in range(N+1):
            dp[j][0] = 1
        
        
        for i in range(1,N+1):
            for j in range(1,S + 1):
                if nums[i-1] != 0 and nums[i-1] <= j:
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]]
                else:
                    dp[i][j] = dp[i-1][j]
        
        count = 0
        for i in nums:
            if i == 0:
                count = count + 1
        
        return 2**count*dp[N][S]
    
            
'''
The question started with an array and a target and we had to add and subtract values to find the target.
Then doing some mathematical logic on it we found that if we just find the count of subsets with the sum = (total + target)/2
We know how to find the count of subsets with given sum
Now what "Count of subset with given sum" has as a twist is the dealing of all the elements in the arrays which are ZERO. 
A subset can be formed with or without a zero. Yes it will give the same sum but it will be two different subsets. 

When it is time to select the value which is <= than the sum: we specifically write to ignore it (nums[i-1] != 0 and nums[i-1] <= sum)
And when it is time to ignore the elements 
either write else(which will include everything which was not selected in the above condition) 
or write nums[i-1] > sum and nums[i-1] ==0

This will make sure that ZERO test cases are not selected. 
And then at the end include all the test cases with zero too.
2 ^ (no. of zero) x answer 
'''
      
