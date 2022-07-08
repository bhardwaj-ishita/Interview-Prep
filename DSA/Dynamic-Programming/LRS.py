#here the question itself states that the two repeating subsequences should not have the same index starting. (i != j)
class Solution:
	def LongestRepeatingSubsequence(self, str):
		# Code here
		l = len(str)
		dp = [[0 for i in range(l+1)] for j in range(l+1)]
		
		for i in range(1,l+1):
		    for j in range(1,l+1):
		        if str[i-1] == str[j-1] and i != j:
		            dp[i][j] = dp[i-1][j-1] + 1
		        else:
		            dp[i][j] = max(dp[i-1][j],dp[i][j-1])
		
		return dp[l][l]
