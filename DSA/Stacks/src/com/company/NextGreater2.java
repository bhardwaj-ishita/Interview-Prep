package com.company;

import java.util.Arrays;

/**
 * <h1>Next Greater Element II</h1>
 * https://leetcode.com/problems/next-greater-element-ii/
 *
 * Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]),
 * return the next greater number for every element in nums.
 *
 * The next greater number of a number x is the first greater number to its traversing-order next in the array,
 * which means you could search circularly to find its next greater number.
 * If it doesn't exist, return -1 for this number.
 *
 * @author Ishita Bhardwaj
 * @version 11.01
 * @since   2021-06-13
 * */
public class NextGreater2 {

    /**
     * This method uses <b>Stack</b>.
     * Instead of traversing all the way over and over
     * We'll save the values side by side in the stack in the reverse order and traverse the list in reverse too once only
     * If the pointer value is greater then pop the stack until a value greater then pointer is achieved
     * If such value is not achieved then assign the pointer 0
     *
     * Now repeat the same process again, this time the elements will get the next greater element assigned to them
     * space complexity: O(n)
     * time complexity: O(n)
     * @param nums The input array
     * @return int[] This array gives all the next greater values respectively with all the node position
     */
    public static int[] method1(int[] nums) {
        int n = nums.length;
        Stack s = new Stack();
        int[] ans = new int[n];

        int i = n-1;

        while(i >= 0) {
            while(!s.isEmpty() && nums[i] >= s.peek()) s.pop();
            if(s.isEmpty()) {
                s.push(nums[i]);
                ans[i] = -1;
            }
            else {
                ans[i] = s.peek();
                s.push(nums[i]);
            }
            i--;
        }

        i = n-1;

        while(i >= 0) {
            while(!s.isEmpty() && nums[i] >= s.peek()) s.pop();
            if(s.isEmpty()) s.push(nums[i]);
            else {
                ans[i] = s.peek();
                s.push(nums[i]);
            }
            i--;
        }
        return ans;
    }

    /**
     * This is the driver code.
     * @param args Unused.
     */
    public static void main(String[] args) {
        int[] arr = {3,-2,-1};
        System.out.println(Arrays.toString(method1(arr)));

    }
}
