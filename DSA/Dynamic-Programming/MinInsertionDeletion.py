class Solution:
	def minOperations(self, s1, s2):
		# code here
		#find s2 as substring in s1. and whatever else is missing insert or delete it
		l1 = len(s1)
		l2 = len(s2)
		sub = self.LCS(s1,s2,l1,l2)
		deletion = l1-sub
		insertion = l2 - sub
		
		return (l1+l2) - 2*sub
	
	def LCS(self,s1,s2,l1,l2):
	   dp = [[0 for i in range(l2+1)] for j in range(l1+1)]
	   for i in range(1,l1+1):
	       for j in range(1,l2+1):
	           if s1[i-1] == s2[j-1]:
	                dp[i][j] = dp[i-1][j-1] + 1
	           else:
	               dp[i][j] = max(dp[i-1][j],dp[i][j-1])
	   
	   
	   return dp[l1][l2]
