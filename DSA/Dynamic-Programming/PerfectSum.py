#Memoization (for recursion, you can sort the array such that, the zero elements are first dealt thus not leaving any subset)
class Solution:
    
    def perfectSum(self, arr, N, S):
        # code here
        dp = [[None for i in range(S+1)]for j in range(N+1)]
        arr.sort()
        arr = arr[::-1]
        return self.sol(N,S,arr,dp)%(10**9 + 7)
    
    def sol(self, N, S, arr,dp):
        if S == 0: 
            return 1
        if S < 0 or N == 0:
            return 0
        
        if dp[N][S] is not None:
            return dp[N][S]
        
        
        if arr[N-1] <= S:
            dp[N][S] = self.sol(N-1,S-arr[N-1],arr,dp) + self.sol(N-1,S,arr,dp)
        elif arr[N-1] > S:
            dp[N][S] = self.sol(N-1,S,arr,dp)
        
        return dp[N][S]

#Tabular (first solve for all non zero elements and then add all subsets including zero)
class Solution:
    
    def perfectSum(self, arr, N, S):
        
        for i in range(S+1):
            dp[0][i] = 0
        for j in range(N+1):
            dp[j][0] = 1
            
        for i in range(1,N+1):
            for j in range(1,S + 1):
                if arr[i-1] <= S:
                  dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j]
              elif arr[i-1] > S:
                  dp[i][j] = dp[i-1][j]
        
        count = 0
        for i in nums:
            if i == 0:
                count = count + 1
        
        return 2**count*dp[N][S]
    
