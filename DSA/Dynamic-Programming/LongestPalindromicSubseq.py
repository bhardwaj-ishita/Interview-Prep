#Memoization
class Solution:
    def longestPalindromeSubseq(self, s: str) -> int:
        
        def dp(l1,l2):
            if l1>l2:
                return 0
            if l1 == l2:
                return 1
            if dp1[l1][l2] != -1:
                return dp1[l1][l2]
            
            if s[l1] == s[l2]:
                dp1[l1][l2] = dp(l1+1,l2-1) + 2
            else:
                dp1[l1][l2] = max(dp(l1+1,l2),dp(l1,l2-1))
            
            return dp1[l1][l2]
        
        l = len(s)
        dp1 = [[-1 for i in range(l+1)]for j in range(l+1)]
        return dp(0,l-1)

#Tabular
class Solution:
    def longestPalindromeSubseq(self, s: str) -> int:
        
        l = len(s)
        s2 = s[::-1]
        dp = [[0 for i in range(l+1)]for j in range(l+1)]
        
        
        for i in range(1,l+1):
            for j in range(1,l+1):
                if s[i-1] == s2[j-1]:
                    dp[i][j] = dp[i-1][j-1] + 1
                else:
                    dp[i][j] = max(dp[i-1][j],dp[i][j-1])
        
        return dp[l][l]
                
