package com.company;

/**
 * Here the time constraint was given O(log n)
 * but in this dp if we have to find two operations for all n values then the time leads to O(2^n)
 *
 * Hence to achieve a (log n) stage we'll get something like a binary search algorithm, where at every traversal
 * we only need to look towards one of the two operations because if the number n is divisible by n
 * then it will give the min number of operations only when we end up at an odd number we'll take n-1 operation
 *
 * hence approximately at every traversal their is a very high chance that we'll be minimizing n by 2 as their is
 * a 50% probability the number is even
 */
public class MinOperations {

    public static int minOperation(int n)
    {
        int[] dp = new int[n+1];

        for(int i = 0 ; i < n + 1; i++)
            dp[i] = -1;

        dp[0] = 0;

        return dynamic(n,dp);
    }

    public static int dynamic(int n, int[] dp) {
        if(n==0) return dp[0];

        if(dp[n] != -1)
            return dp[n];

        dp[n] = n%2==0 ? dynamic(n/2,dp)+1 : dynamic(n-1,dp)+1;

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(minOperation(7));
    }
}
