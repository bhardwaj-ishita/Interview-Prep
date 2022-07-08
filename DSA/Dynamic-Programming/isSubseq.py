#Unncecessary DP
class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        l1 = len(t)
        l2 = len(s)
        
        dp = [[0 for i in range(l2+1)] for j in range(l1+1)]
        
        for i in range(1,l1+1):
            for j in range(1,l2+1):
                if t[i-1] == s[j-1]:
                    dp[i][j] = dp[i-1][j-1] + 1
                else:
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1])
        
        return dp[l1][l2] == len(s)

#Two pointers
class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        l1 = len(t)
        l2 = len(s)
        
        i,j = 0,0
        length = 0
        while i < l1 and j < l2:
            if t[i] == s[j]:
                length = length + 1
                i = i + 1
                j = j + 1
            else:
                i = i + 1

        
        return length == len(s)
