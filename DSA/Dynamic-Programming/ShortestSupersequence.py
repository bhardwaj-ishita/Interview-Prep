class Solution:
    
    #Function to find length of shortest common supersequence of two strings.
    #Supersequence is both the string merged in one in the same order, not necessarily together
    #Shortest Supersequence is the shortest string which includes both strings as subsequence
    #worst case would be if you merge both strings together X + Y
    #Here some letters would be repetitive
    #So remove the repetitive letters i.e the subsequence of X and Y
    def shortestCommonSupersequence(self, X, Y, m, n):
        
        #code here
         
        dp = [[0 for i in range(n+1)] for j in range(m+1)]
         
        for i in range(1,m+1):
            for j in range(1,n+1):
                if X[i-1] == Y[j-1]:
                    dp[i][j] = dp[i-1][j-1] + 1
                else:
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1])
        
        return m + n - dp[m][n]
