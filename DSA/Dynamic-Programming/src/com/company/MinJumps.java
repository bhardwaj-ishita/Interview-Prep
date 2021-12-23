package com.company;

public class MinJumps {

    public static int minJumps(int[] arr){
        if (arr.length <= 1)
            return 0;

        if (arr[0] == 0)
            return -1;

        int n = arr.length;
        int[] dp = new int[n];
        for(int i = 0; i < n; i++) dp[i] = Integer.MAX_VALUE;
        dp[n-1] = 0;


        for(int i=n-2; i>= 0; i--) {
            for(int j = i; j < n; j++) {
                Math.min()
            }
        }

        return sol(arr,0, n-1 ,dp);
    }

    public static int sol(int[] a, int l, int n, int[] dp) {
        if(l==n) return 0;

        if(a[l] == 0) {
            dp[l] = -1;
            return Integer.MAX_VALUE;
        }

        if(dp[l] != Integer.MAX_VALUE) return dp[l];

        int ans = Integer.MAX_VALUE;
        for(int i = l+1; i <= n && i <= l + a[n]; i++) {
            ans = Math.min(ans,sol(a,i,n,dp) + 1);

        }
        dp[l] = ans;
        System.out.println("l: " + l + " dp[l]: " + dp[l]);

        return dp[l];
    }
}
