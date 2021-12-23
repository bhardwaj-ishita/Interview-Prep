package com.company;

public class LCSubSequence {

    /**
     * LCS
     * it is a dp problem
     * we convert both strings to charArray for easiness
     *
     * assume we take two strings and compare there last char
     * --if both of them are equal we remove both chars and now check the remaining characters
     * --if both of them are not same then you'll either remove last char of S1 or last char of S2 i.e.
     *  [S1(n-1),S2(m)] OR [S1(n),S2(m-1)]
     *
     *
     *  So similarly in this algorithm we start from the starting
     *  and here we inlcude the null string too for comparison
     *
     *  if S1 is null or S2 is null then there won't be any LCS ever so we write the first case as
     *  --- if any of them is null then put dp[i][j] == 0
     *  (here the index shows how many characters are present right now in the strings for comparison)
     *
     *  if the characters at those pointers are equal then we add 1 to S1(i-1),S2(j-1) index/strings
     *
     *  when find equal chars (diagonal) abcc - adbc {c and c are equal, hence add abc - adb value + 1}
     *  when don't find equal ( preceding column or preceding row of the current index)
     *      abcd - adbc {d and c are not equal to current value = max value of (abcd-adb or abc-adbc)}
     *
     * @param A string 1
     * @param B string B
     * @return longest common substring
     */
    public int solve(String A, String B) {
        int n = A.length();
        int m = B.length();
        char[] x = A.toCharArray();
        char[] y = B.toCharArray();
        int[][] dp = new int[n+1][m+1];

        for(int i = 0; i < n+1; i++) {
            for(int j = 0; j < m+1; j++) {
                if(i==0||j==0) dp[i][j] = 0;
                else if(x[i-1] == y[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                //System.out.println(dp[i][j]);
            }
        }
        return dp[n][m];

    }
}
