package com.company;

public class KnapSackOG {
    public static int knapSack(int W, int wt[], int val[], int n)
    {
        int[][] dp = new int[n+1][W+1];
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= W;j++) {
                dp[i][j] = -1;
            }
        }
        return sol(W,wt,val,n,dp);


    }

    public static int sol(int W, int wt[], int val[], int n, int[][] dp)
    {
        if(n==0 || W==0) return 0;
        if(dp[n][W] != -1) return dp[n][W];
        if(W < wt[n-1])
            return sol(W,wt,val,n-1,dp);
        dp[n][W] = Math.max(val[n-1] + sol(W-wt[n-1],wt,val,n-1,dp),sol(W,wt,val,n-1,dp));
        return dp[n][W];
    }
}
