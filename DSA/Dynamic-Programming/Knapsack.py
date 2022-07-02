#Memoization

class Solution:
    
    #Function to return max value that can be put in knapsack of capacity W.
    def knapSack(self,W, wt, val, n):
        dp = [[None for i in range(n + 1)] for j in range(W + 1)]
        return self.sol(W,n,wt,val,dp)
        
        
    def sol(self,W,n,wt,val,dp):
        #base condition
        if W <= 0 or n == 0:
            return 0
        
        #use of memoization
        if dp[W][n] is not None:
            return dp[W][n]
        
        #else memoize it i.e. store it
        #choice conditions
        if wt[n-1] > W:
            dp[W][n] = self.sol(W,n-1,wt,val,dp)
        elif wt[n-1] <= W:
            dp[W][n] =  max(val[n-1] + self.sol(W-wt[n-1],n-1,wt,val,dp) ,self.sol(W,n-1,wt,val,dp))
        
        return dp[W][n] 
        
#Tabular

class Solution:
    
    #Function to return max value that can be put in knapsack of capacity W.
    def knapSack(self,W, wt, val, N):
        
        
        dp = [[0 for i in range(W + 1)] for j in range(N + 1)]
        
        for n in range(1,N+1):
            for w in range(1,W+1):
                if wt[n-1] <= w:
                    dp[n][w] = max(val[n-1] + dp[n-1][w-wt[n-1]], dp[n-1][w])
                else:
                    dp[n][w] = dp[n-1][w]
        
        return dp[N][W]    
