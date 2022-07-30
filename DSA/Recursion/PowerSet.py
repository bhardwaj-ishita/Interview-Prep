'''
Here in the question is asked to find all subsequences of the string
And print them in lexicographical order

Why I have added a pop funciton at the end?
Because the last subsequence added in the list is an empty string and that is not a power set
So I popped it and sorted it and returned


And one thing you'll notice when you draw the recursion tree of this question is that all the unique subsequences can be found at the leaf nodes.
So no need to append the strings in the middle. Add them when you reach the leaf node.
And their is a choice in this question, you either add the char at ith position or not

'''

class Solution:
	def AllPossibleStrings(self, s):
		# Code here
		ans = self.sol(s,len(s), [], "")
		ans.pop()
		ans.sort()
		return ans
	def sol(self, s, n, ans, temp):
	    if n==0:
	        ans.append(temp)
	        return ans
	    
	    self.sol(s,n-1,ans, s[n-1] + temp)
	    self.sol(s,n-1,ans, temp)
	    
	    return ans
