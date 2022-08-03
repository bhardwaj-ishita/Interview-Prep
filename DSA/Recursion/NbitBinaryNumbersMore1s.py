'''
Started the recursion from 0th index and added 1s and 0s at the end and keep comparing if the count >= ceil(n/2) ever
If it does, we don't want it
'''

import math
class Solution:
	def NBitBinary(self, N):
		# code here
		ans = []
		self.sol(0,ans,"",0,N)
		return ans
		
	def sol(self,n,ans,temp,count,N):
	    if n == N:
	        if count >= math.ceil(n/2):
	            ans.append(temp)
            return ans
        
        
        if count >= math.ceil(n/2):
            self.sol(n+1,ans,temp+"1",count+1,N)
            self.sol(n+1,ans,temp+"0",count,N)
        
        
        return ans
