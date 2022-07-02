#Memoization
class Solution:
    def minDifference(self, arr, n):
        # code here
        sum = 0
        for i in arr:
            sum = sum + i
        dp = [[None for i in range(sum+1)] for j in range(N+1)]
        return self.diff(n,0,0,arr,dp,sum)
        
    def diff(self, N, sum1, sum2, arr,dp,sum):
        if N==0:
            return abs(sum1-sum2)
        
        if dp[N][sum1] is not None:
            return dp[N][sum1]
        
        dp[N][sum1] = min(self.diff(N-1,sum1+arr[N-1],sum2,arr,dp,sum),self.diff(N-1, sum1, sum2+arr[N-1],arr,dp,sum))
        
        return dp[N][sum1]


#Tabular
class Solution:
	def minDifference(self, arr, N):
		# code here
		total = sum(arr)
		dp = [[0 for i in range(total+1)] for j in range(N+1)]
		
		#we know that it's like subset sum where we need to find the subset whose sum is equal to S
		#here we'll have two sums. But we don't know there values. 
		#we need to find the minimum value for the difference between them
		# so what we can assume that the min difference ==0 and max difference == total (0,total)
		# so one of the sums(let it be sum1) will be in the range(0,total//2)
		#now in the subset sum the dp[N][j] gives us the info that a subset of sum j is possible or not
		#using that information we'll find the sum2 and find the min difference and return it
		
		#subset sum problem
		for i in range(N+1):
		    for j in range(total+1):
		        if j == 0:
		            dp[i][j] = 1
	            elif i == 0:
	                dp[i][j] = 0
                elif arr[i-1] <= j:
                    dp[i][j] = (dp[i-1][j] or dp[i-1][j-arr[i-1]])
                elif arr[i-1] > j:
                    dp[i][j] = dp[i-1][j]
        
        mid = total//2
        diff = total
        #we know the possible values of sum1 
        for i in range(mid+1):
            if dp[N][i] == 1:
                sum2 = total - i
                sum1 = i
                diff = min(diff,sum2-sum1)
        
        return diff
