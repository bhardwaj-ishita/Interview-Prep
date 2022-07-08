#Tabular
class Solution:
    def minDeletions(self, s, n): 
        #code here
        #Let's assume a palindrome already exists in the string 
        #But a few extra elements are also there
        #So to find the palindrome we'll have to remove those extra elements
        #we'll get the palindrom size in the string and subtract it from the total size of the string
        
        #reverse the list
        s2 = s[::-1]
        
        dp = [[-1 for i in range(n+1)]for j in range(n+1)]
        
        #LCS
        for i in range(1,n+1):
            for j in range(1,n+1):
                if s[i-1] == s2[j-1]:
                    dp[i][j]=dp[i-1][j-1] + 1
                else:
                    dp[i][j] = max(dp[i-1][j],dp[i][j-1])
                    
        return (n - dp[n][n] - 1)

#Memoization: not able to solve all test cases
class Solution:
    def minDeletions(self, s, n): 
        #code here
        #Let's assume a palindrome already exists in the string 
        #But a few extra elements are also there
        #So to find the palindrome we'll have to remove those extra elements
        #we'll get the palindrom size in the string and subtract it from the total size of the string
        
        #LCS
        def lcs(l1,l2):
            if l1 > l2:
                return 0
            if l1==l2:
                return 1
            
            if dp[l1][l2] != -1:
                return dp[l1][l2]
            
            if s[l1] == s[l2]:
                dp[l1][l2] = lcs(l1+1,l2-1) + 2
            else:
                dp[l1][l2] = max(lcs(l1+1,l2), lcs(l1,l2-1))
            return dp[l1][l2]
        
        dp = [[-1 for i in range(n+1)]for j in range(n+1)]
        palindrome = lcs(0,n-1)
        return n - palindrome
