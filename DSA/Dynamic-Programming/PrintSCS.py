#derived from PrintLCS

class Solution:
    def shortestCommonSupersequence(self, s1: str, s2: str) -> str:
        l1 = len(s1)
        l2 = len(s2)
        dp = [[0 for i in range(l2+1)] for j in range(l1+1)]
        
        for i in range(1,l1+1):
            for j in range(1,l2+1):
                if s1[i-1] == s2[j-1]:
                    dp[i][j] = dp[i-1][j-1] + 1
                else:
                    dp[i][j] = max(dp[i-1][j],dp[i][j-1])
        
        ans = []
        i,j = l1,l2
        while i > 0 and j > 0:
            if i > 0 and j > 0 and s1[i-1] == s2[j-1]:
                ans.append(s1[i-1])
                i = i - 1
                j = j - 1
            else:
                if dp[i-1][j] < dp[i][j-1]:
                    ans.append(s2[j-1])
                    j = j - 1
                else:
                    ans.append(s1[i-1])
                    i = i - 1
                    
        while i > 0:
            ans.append(s1[i-1])
            i = i - 1
        while j > 0:
            ans.append(s2[j-1])
            j = j - 1
            
        return ans[::-1]
