#Tabular
def longestCommonSubsequence(a, b):
    # Write your code here
    dp = [[0 for i in range(len(b) + 1)] for j in range(len(a) + 1)]
    
    for i in range(1,len(a) + 1):
        for j in range(1,len(b) + 1):
            if a[i-1] == b[j-1]:
                dp[i][j] = dp[i-1][j-1] + 1
            else:
                dp[i][j] = max(dp[i-1][j],dp[i][j-1])
    

    ans = []
    i = len(a)
    j = len(b)            
    while i > 0 and j > 0:
        if a[i-1] == b[j-1]:
            ans.append(str(a[i-1]))
            i = i - 1
            j = j - 1
        else:
            if dp[i-1][j] < dp[i][j-1]:
                j = j - 1
            else:
                i = i - 1
    
    return ans[::-1]
