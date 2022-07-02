#Memoization
class Solution:
    def cutRod(self, price, N):
        #code here
        L = N
        dp = [[None for i in range(L+1)] for j in range(N+1)]
        return self.sol(L,N,price,dp)
        
    def sol(self, L,N,price,dp):
        if L <= 0 or N==0:
            return 0
        
        if dp[N][L] != None:
            return dp[N][L]
        
        
        if N <= L:
            take = self.sol(L-N,N,price,dp)
            not_take = self.sol(L,N-1,price,dp)
            dp[N][L] = max(price[N-1] + take, not_take)
        elif N > L:
            dp[N][L] = self.sol(L,N-1,price,dp)
        
        return dp[N][L]

#Tabular
class Solution:
    def cutRod(self, price, N):
        #code here
        L = N
        dp = [[0 for i in range(L+1)] for j in range(N+1)]
        
        
        for i in range(1,N+1):
            for j in range(1,L+1):
                if i <= j:
                    dp[i][j] = max(price[i-1] + dp[i][j-i], dp[i-1][j])
                elif i > j:
                    dp[i][j] = dp[i-1][j]
                    
        
        return dp[N][L]
