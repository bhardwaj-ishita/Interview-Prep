#Memoization

class Solution:
    def knapSack(self, N, W, val, wt):
        # code here
        dp = [[None for i in range(W+1)] for j in range(N+1)]
        return self.sol(N,W,val,wt,dp)
        
    def sol(self, N, W, val, wt, dp):
        if N==0 or W<=0:
            return 0
        
        if dp[N][W] != None:
            return dp[N][W]
        
        if wt[N-1] <= W:
            take = self.sol(N,W-wt[N-1],val,wt,dp)
            not_take = self.sol(N-1,W,val,wt,dp)
            dp[N][W] = max(val[N-1] + take, not_take)
            
        elif wt[N-1] > W:
            dp[N][W] = self.sol(N-1,W,val,wt,dp)
            
        return dp[N][W]
      
#Tabular
class Solution:
    def knapSack(self, N, W, val, wt):
        # code here
        dp = [[0 for i in range(W+1)] for j in range(N+1)]
        
        for i in range(N+1):
            for j in range(W+1):
                if wt[i-1] <= j:
                    dp[i][j] = max(dp[i-1][j], val[i-1] + dp[i][j-wt[i-1]])
                elif wt[i-1] > j:
                    dp[i][j] = dp[i-1][j]
        
        return dp[N][W]
