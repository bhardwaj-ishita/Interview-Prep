package com.company;

public class LCSubstring {

    /**
     *
     * similar to LCSubsequence
     * but instead when the chars are not equal you don't put the value at current index as max of the past
     * indices (i-1,j OR i,j-1)
     * but put it as ZERO and start again.
     *
     * and keep a check of the max value
     *
     * @param S1 string
     * @param S2 string
     * @param n size of S1
     * @param m size of S2
     * @return
     */
    public static int longestCommonSubstr(String S1, String S2, int n, int m){
        int[][] dp = new int[n+1][m+1];
        char[] x = S1.toCharArray();
        char[] y = S2.toCharArray();
        int ans = 0;
        for(int i = 0; i <= n;i++) {
            for(int j = 0; j <= m;j++) {
                if(i==0||j==0) dp[i][j] = 0;
                else if(x[i-1] == y[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    ans = Math.max(ans,dp[i][j]);
                }
                else dp[i][j] = 0;
            }
        }
        return ans;
    }
}
