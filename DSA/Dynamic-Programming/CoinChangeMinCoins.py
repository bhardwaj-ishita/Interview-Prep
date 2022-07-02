#Refer to notes
#Memoization
import sys
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        S = amount
        N = len(coins)
        dp = [[-1 for i in range(S+1)] for j in range(N+1)]
        
        ans = self.sol(N,S,coins,dp)
        if ans == sys.maxsize - 1:
            return -1
        return ans

    def sol(self,N,S,coins,dp):
        if S==0:
            return 0
        elif N==0:
            return sys.maxsize - 1
        
        '''if S%coins[N-1] == 0:
            return S/coins[N-1]
        else:
            return sys.maxsize - 1'''
        
        if dp[N][S] != -1:
            return dp[N][S]
       
        if coins[N-1] > S:
            dp[N][S] = self.sol(N-1,S,coins,dp)
        else:
            dp[N][S] = min(1+self.sol(N,S-coins[N-1],coins,dp), self.sol(N-1,S,coins,dp))
        
        return dp[N][S]

#Tabular
import sys
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        S = amount
        N = len(coins)
        dp = [[0 for i in range(S+1)] for j in range(N+1)]
        
        for i in range(S+1):
            dp[0][i] = sys.maxsize
        for i in range(N+1):
            dp[i][0] = 0
            
        for i in range(S+1):
            if i%coins[0] == 0:
                dp[1][i] = i//coins[0]
            else:
                dp[1][i] = sys.maxsize 
        
        for i in range(2,N+1):
            for j in range(1,S+1):
                if coins[i-1] <= j:
                    dp[i][j] = min(1+dp[i][j-coins[i-1]], dp[i-1][j])       
                elif coins[i-1] > j:
                    dp[i][j] = dp[i-1][j]
        
        
        if dp[N][S] == sys.maxsize :
            return -1
        return dp[N][S]
