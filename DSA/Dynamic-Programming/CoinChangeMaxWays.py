#Memoization
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        S = amount
        N = len(coins)
        dp = [[None for i in range(S+1)]for j in range(N+1)]
        return self.sol(N,S,coins,dp)
    
    def sol(self, N, S, coins, dp):
        if S==0:
            return 1
        if N==0 or S < 0:
            return 0
        
        if dp[N][S] != None:
            return dp[N][S]
        
        if coins[N-1] <= S:
            dp[N][S] = self.sol(N,S-coins[N-1],coins,dp) + self.sol(N-1,S,coins,dp)
        if coins[N-1] > S:
            dp[N][S] = self.sol(N-1,S,coins,dp)
        
        return dp[N][S]

#Tabular
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        S = amount
        N = len(coins)
        dp = [[0 for i in range(S+1)]for j in range(N+1)]
        
        for j in range(S+1):
            dp[0][j] = 0
        for i in range(N+1):
            dp[i][0] = 1
            
            
        for i in range(1,N+1):
            for j in range(1,S+1):
                if coins[i-1] <= j:
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j]
                elif coins[i-1] > j:
                    dp[i][j] = dp[i-1][j]
        
        return dp[N][S]
