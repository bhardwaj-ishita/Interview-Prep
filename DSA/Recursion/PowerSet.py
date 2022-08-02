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
	
'''
"array nums of unique elements" it is given in the question that the input has unique elements in it.
So we don't need to take care of duplicates
We just need to print. Hence we can use a list

A set would've taken care of duplicates

Lists

- ordered
- mutable
- [a,b,c]
- it is an object which contains any kind of object, like, a list, a set, diff data types etc

Tuples

- ordered
- immutable
- once in a lifetime of the code it is created: once created, it remains intact
- (a,b,c)
- prevents accidental addition or deletion of the data
- use less memory and program execution faster than list, as every time a new execution is done with lists, new objects are created, and the objects are not interpreted just once

Sets

- unique in the use case; mostly used to take care of duplicates
- mutable
- {a,b,c}
- used to check whether a set is a subset of another set and to identify the relationship between two sets
'''	
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        ans = []
        self.sol(nums,len(nums),ans,[])
            
        return ans
        
    def sol(self, a, n, ans, temp):
        if n == 0:
            ans.append(temp)
            return ans
        
        self.sol(a,n-1,ans,temp)
        self.sol(a,n-1,ans,[a[n-1]] + temp)
        
        
        return ans
