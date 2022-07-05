#Memoization
class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        dp = [[None for i in range(len(text2)+1)] for j in range(len(text1)+1)]
        return self.sol(text1,text2,len(text1),len(text2),dp)
        
    def sol(self, S1, S2, L1, L2,dp):
        if L1 == 0 or L2 == 0:
            return 0
        
        if dp[L1][L2] != None:
            return dp[L1][L2]
        
        if S1[L1-1] == S2[L2-1]:
            dp[L1][L2] = self.sol(S1,S2,L1-1,L2-1,dp) + 1
        else:
            dp[L1][L2] = max(self.sol(S1,S2,L1-1,L2,dp) , self.sol(S1,S2,L1,L2-1,dp))
        
        return dp[L1][L2]

#Tabular
class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        L1 = len(text1)
        L2 = len(text2)
        dp = [[0 for i in range(L2+1)] for j in range(L1+1)]
        
        for i in range(1,L1+1):
            for j in range(1,L2 + 1):
                if text1[i-1] == text2[j-1]:
                    dp[i][j] = dp[i-1][j-1] + 1
                else:
                    dp[i][j] = max(dp[i-1][j] , dp[i][j-1])
        
        return dp[L1][L2]
        
    
#instead of adding the recursive calls, we'll take the max. 
#1. because we are trying to find the longest subsequence
#2. because if we'll add the calls, there might be repetitive cases. And all will add up
