#Memoization

class Solution:
    def isSubsetSum (self, N, arr, sum):
        # code here
        dp = [[-1 for i in range(sum+1)] for j in range(N+1)]
        return self.recur(N,sum,dp)
    
    def recur(self,N,sum,dp):
        if N == 0 or sum ==0:
            return 0
        if arr[N-1] == sum:
            return 1
        
        if dp[N][sum] is not -1:
            return dp[N][sum]
        
        if arr[N-1] < sum:
            dp[N][sum] = self.recur(N-1, sum - arr[N-1],dp) or self.recur(N-1, sum,dp)
        else:
            dp[N][sum] = self.recur(N-1,sum,dp)  
            
        return dp[N][sum]
        
        
#Tabular
class Solution:
    def isSubsetSum (self, N, arr, sum):
        # code here
        dp = [[0 for i in range(sum+1)] for j in range(N+1)]
        
        for i in range(1,N+1):
            for j in range(1,sum+1):
                if i == 0:
                    dp[i][j] = 1
                if j == 0:
                    dp[i][j] = 0
                if arr[i-1] == j:
                    dp[i][j] = 1
                elif arr[i-1] < j:
                    dp[i][j] = dp[i-1][j-arr[i-1]] or dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j]
        
        return dp[N][sum]
