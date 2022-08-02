'''
Again the question was about how you output the solution mainly

A few ways you can change the order of output is interchanging recursive calls order
Or you can start the recursion top to bottom OR bottom to top (start = 0 or start = n)
'''
class Solution:
    def permutation (self, S):
        # code here
        ans = self.sol(S,len(S),0,[],"")
        return ans
        pass
    
    def sol(self, s, n, i, ans, temp):
        if i == n-1:
            ans.append(temp+s[i])
            return ans
        
        temp = temp + s[i]
        self.sol(s,n,i+1,ans,temp+" ") 
        self.sol(s,n,i+1,ans,temp)
        
        return ans
