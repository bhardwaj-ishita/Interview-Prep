class Solution:
    
    
    
    '''
    So in this question we need to put cuts(brackets) to make a string with it's subsets as palindormes
    in the range check if it is a palindrome
    The for loop is to check all the subsets
    The condition(variable) is decided by the temp and base condition
    Everything else is the same
    
    A few opitmization ideas:
    1. use dp
    2. use a ispalindrome() dp to not calculate again and again if the string is palindrome or not. It will store if the current string is true or not (a palindrome)
    3. there might be a chance that the left recursive call was calculated even before the parent call was made. so we'll have to wait for the parent call to happen. What we can do is, instead calling all recursive calls together, call them one by one and check if they were already called before. Basically use (dp[i][j] != -1: retun dp[i][j]) condition for all calls
    4. They are saying if the left recursive call is not a palindrome then it won't be of any use to call the right call. As they won't contribute to the answer.
    This happens so because we are looking for an optimal answer. If left is not a palindrome it will only go towards the worst case, whereas we are tryig to go to the
    opitmal answer. So we leave this situation and move further. Hence instead of doing all recursive calls we only do those which help us in getting closer to the 
    optimal answer
    '''
    
    def minCut(self, string: str) -> int:
        if not string or len(string) <= 1:
            return 0
        if self.palindrome(string):
            return 0
        
        n = len(string)
        
        #Optimization 1
        dp = [[-1 for i in range(n)] for j in range(n)]
        
        #Optimization 2
        p = [[False for i in range(n)] for j in range(n)]
        
        return self.solve(string, 0, n-1, dp, p)
        
    def solve(self, s, i , j, dp, p):
        if i>= j:
            return 0
        elif dp[i][j] != -1:
            return dp[i][j]
        elif p[i][j]:
            return 0
        elif self.palindrome(s[i:j+1]):
            p[i][j] = True
            return 0
        
        ans = j
        for k in range(i,j):
            #Optimization 4
            if self.palindrome(s[i:k+1]):
                temp = self.solve(s,k+1,j,dp,p) + 1
                ans = min(ans,temp)
        
        dp[i][j] = ans
        return dp[i][j]
    
    
    def palindrome(self, s):
        return s == s[::-1]
        
