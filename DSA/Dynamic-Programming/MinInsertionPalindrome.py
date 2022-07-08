class Solution:
    def minInsertions(self, s: str) -> int:
        #find palindrome in the given string
        #and len(s) - palindrome == extra elements
        # those are the elements we need to insert again to make it as a whole a palindrome
        
        l = len(s)
        s2 = s[::-1]
        dp = [[0 for i in range(l+1)]for j in range(l+1)]
        
        for i in range(1,l+1):
            for j in range(1,l+1):
                if s[i-1] == s2[j-1]:
                    dp[i][j] = dp[i-1][j-1] + 1
                else:
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1])
        
        return l - dp[l][l]
