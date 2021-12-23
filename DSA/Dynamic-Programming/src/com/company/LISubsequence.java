package com.company;

public class LISubsequence {

    /**
     * This is the bottom up dp approach.
     * Base case here is that the first index will always have 1 longest subseq
     * hence dp[0] = 1
     *
     * as we traverse further from 1 to n
     * we'll search for the max val in the dp array with the jth term being smaller than the ith term
     * and finally in dp[i] = max(dp[(0 to j) < i]) + 1;
     * @param size size of the array
     * @param a input array
     * @return length of the longest subsequence
     *
     * Time complexity of this approach is O(n*n)
     * Space complexity for this approach is O(n) where n is the size of the array
     *
     * There is a solution with time complexity O(nlog n) which is not exactly dp
     */
    public static int longestSubsequence(int size, int a[])
    {
        int[] dp = new int[size];
        dp[0] = 1;
        for(int i = 1; i < size; i++) {
            int maxVal = 0;
            for(int j = 0; j < i; j++) {
                if(a[j] < a[i]) maxVal = Math.max(maxVal,dp[j]);
            }
            dp[i] = maxVal + 1;
        }
        int max = 0;
        for(int i = 0; i < size; i++) max = Math.max(max,dp[i]);
        return max;
    }


    /**
     * This is the optimized approach with time complexity O(nLog n)
     * There are two loops here too but the second loop uses binary search hence the n and log n
     * we make an array which stores the last element of all the active sub subsequences we have
     * and the index + 1 denote the length of that particular subsequence
     *
     * Now the main logic of this algorithm is we'll make many subsequences side by side
     * and as we traverse the input array we'll come across 3 cases:
     * 1) if a[i] is greater than all the tails then we'll clone the largest subseq and add a[i] to it as tail
     * 2) if a[i] is smaller than all the tails then we'll make a new active subseq and remove all the
     * subseq with this length
     * 3) if a[i] lies between the largest and smallest then find the larges subseq whose tail is smaller
     * than a[i] and clone it and add a[i] to it as tail
     *
     * we need to maintain the tail and the size of the largest sub seq
     * and to find the index for case 2) we apply binary search as the tails are already in sorted order
     *
     * also the index is 0-based and the subsequence length start at 1 so we'll have to make sure while
     * getting any value from the array we put index as (len - 1)
     *
     * @param size
     * @param a
     * @return
     */
    public static int nonDp(int size, int a[]) {
        int[] tailIndex = new int[size];
        tailIndex[0] = a[0];
        int len = 1;
        for(int i = 0; i < size; i++) {
            if(a[i] < tailIndex[0]) tailIndex[0] = a[i];
            else if(a[i] > tailIndex[len-1]) tailIndex[len++] = a[i];
            else tailIndex[findIndex(-1,len-1,a[i],tailIndex)] = a[i];
        }

        return len + 1;
    }

    public static int findIndex(int l, int r, int key ,int[] tailIndex) {
        while(r-l > 1) {
            int m = l + (r-l)/2;
            if(tailIndex[m] <= key) l = m;
            else r = m;
        }
        return r;
    }

}
