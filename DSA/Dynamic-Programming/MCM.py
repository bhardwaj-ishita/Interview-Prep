import sys
class Solution:
    
    '''
    So we need to put brackets around the ip such that we get the minimum ans
    
    we'll use recursion for this kind of question
    We start with the base condition
    As we know ith matrix is a[i-1] x a[i]
    So we at least need two indices in an array at a time
    
    Next how to put the brackets?
    Our task is to put the outermost brackets
    The recursion will then help in putting all the inner brackets as we go.
    So all the possible ways to put a bracket in the ip is (x elements)(y elements)
    With the base condition ofcourse that none of the brackets are empty
    
    now as you've sent those two brackets for further bracketization
    the moment all the answers come back, the final ans would be the product of both the brackets
    what will be it's format.
    In matrices matrix A[x*y] and matrix B[y*z] dimensions, then the final product dimentsion is
    C[x*z].
    So after all those products, the final product will be x*y*z
    '''
    def matrixMultiplication(self, N, arr):
        # code here
        dp = [[-1 for i in range(N+1)] for j in range(N+1)]
        return self.solve(arr,1,N-1,dp)
        
    def solve(self, arr, i, j, dp):
        if i >= j:
            return 0
            
        if dp[i][j] != -1:
            return dp[i][j]
            
        ans = sys.maxsize
        for k in range(i,j):
            temp = self.solve(arr,i,k,dp) + self.solve(arr,k+1,j,dp) + (arr[i-1]*arr[k]*arr[j])
            ans = min(ans, temp)
        
        dp[i][j] = ans
        return dp[i][j]
