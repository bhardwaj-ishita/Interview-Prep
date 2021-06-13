package com.company;

import java.util.Arrays;
import java.util.Stack;

/**
 * <h1>Next Smaller Element</h1>
 * https://www.interviewbit.com/problems/nearest-smaller-element/#
 *
 * Given an array, find the nearest smaller element G[i] for every element A[i] in the array
 * such that the element has an index smaller than i.
 *
 *
 * @author Ishita Bhardwaj
 * @version 11.01
 * @since   2021-06-13
 * */
public class NextSmaller {

    /**
     * This method uses <b>Stack</b>.
     * Instead of traversing all the way over and over
     * We'll save the values side by side in the stack in the reverse order and traverse the list in reverse too once only
     * If the pointer value is greater then pop the stack until a value greater then pointer is achieved
     * If such value is not achieved then assign the pointer 0
     * space complexity: O(n)
     * time complexity: O(n)
     * @param arr The input array
     * @return int[] This array gives all the next greater values respectively with all the node position
     */
    public static int[] method1(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];

        Stack<Integer> s = new Stack<>();

        int i = 0;

        while(i < n) {
            while(!s.isEmpty() && arr[i] <= s.peek()) s.pop();

            if(s.isEmpty()) {
                s.push(arr[i]);
                ans[i] = -1;
                i++;
            }
            else if(!s.isEmpty() && arr[i] > s.peek()) {
                ans[i] = s.peek();
                s.push(arr[i]);
                i++;
            }
        }

        return ans;
    }

    /**
     * This is the driver code.
     * @param args Unused.
     */
    public static void main(String[] args) {
        int[] arr = {6,8,0,1,3};
        System.out.println(Arrays.toString(method1(arr)));

    }
}
