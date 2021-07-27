package com.company;

import java.util.Arrays;

public class MergeSortedArrays {
    /**
     * as we keep traversing the array, and the ith index is greater than jth index, then swap the smaller
     * values of arr2 with the larger values of the arr1.
     * Not specifically the ith index but the last values of the arr1
     * and then sort the array
     *
     * Time Complexity: The time complexity while traversing the arrays in while loop is O(n+m)
     * in worst case and sorting is O(nlog(n) + mlog(m)). So overall time complexity of the code
     * becomes O((n+m)log(n+m)).
     *
     * @param arr1
     * @param arr2
     * @param n
     * @param m
     */
    public static void merge(long arr1[], long arr2[], int n, int m)
    {
        int i = 0, j = 0, k = n -1;
        while(i <= k && j < m) {
            if (arr1[i] < arr2[j]) i++;
            else {
                long temp = arr2[j];
                arr2[j] = arr1[k];
                arr1[k] = temp;
                j++;
                k--;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}
