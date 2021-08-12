package com.company;

import java.util.Arrays;

public class MaxLengthChain {

    class Pair {
        int x;
        int y;

        public Pair(int a, int b) {
            x = a;
            y = b;
        }
    }

    /**
     * This is the bottom up approach
     * This question is very similar to the Longest Increasing Subsequence (LIS)
     *
     * @param arr Array of Pairs with arr[i].x as first element of the pair and arr[i].y as second element
     * @param n   It is the size of the array i.e number of pairs we are given
     * @return the max chain length
     */
    public static int maxChainLength(Pair arr[], int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int maxVal = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j].y < arr[i].x) maxVal = Math.max(maxVal, dp[j]);
            }
            dp[i] = maxVal + 1;
        }
        int max = 0;
        for (int i = 0; i < n; i++) max = Math.max(max, dp[i]);
        return max;
    }

    //One variation of the question is when the numbers range from -ve to +ve then
    //leetcode question, here the order is not important, just make the longest chain out of all the given pairs
    public int method1(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);//comparator; lambda function
        int n = pairs.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            int maxVal = 0;
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) maxVal = Math.max(maxVal, dp[j]);
            }
            dp[i] = maxVal + 1;
        }

        int max = 0;
        for (int i = 0; i < n; i++) max = Math.max(max, dp[i]);
        return max;
    }

    public int method2(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int cur = Integer.MIN_VALUE;
        int ans = 0;
        for (int[] pair : pairs) {
            if (cur < pair[0]) {
                cur = pair[1];
                ans++;
            }
        }
        return ans;

    }
}
