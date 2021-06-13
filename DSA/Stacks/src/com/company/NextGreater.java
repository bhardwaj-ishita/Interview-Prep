package com.company;

import java.util.Arrays;

/**
 * <h1>Next Greater Element</h1>
 * https://practice.geeksforgeeks.org/problems/next-larger-element-1587115620/1#
 *
 * Given an array arr[ ] of size N having distinct elements, the task is to find the next greater
 * element for each element of the array in order of their appearance in the array.
 * Next greater element of an element in the array is the nearest element on the right which is
 * greater than the current element.
 * If there does not exist next greater of current element, then next greater element for current
 * element is -1. For example, next greater of the last element is always -1.
 *
 * @author Ishita Bhardwaj
 * @version 11.01
 * @since   2021-06-13
 * */
public class NextGreater {

    /**
     * This method uses <b>Stack</b>.
     * Instead of traversing all the way over and over
     * We'll save the values side by side in the stack in the reverse order and traverse the list in reverse too once only
     * If the pointer value is greater then pop the stack until a value greater then pointer is achieved
     * If such value is not achieved then assign the pointer 0
     * space complexity: O(n)
     * time complexity: O(n)
     * @param arr The input array
     * @param n size of the array
     * @return int[] This array gives all the next greater values respectively with all the node position
     */
    public static int[] method1(int[] arr, int n)
    {
        int[] ans = new int[n];
        Stack s = new Stack();
        int i = n-1;
        while(i >= 0 ) {
            while(!s.isEmpty() && arr[i] >= s.peek()) s.pop();

            if(s.isEmpty()) {
                s.push(arr[i]);
                ans[i] = -1;
                i--;
            }

            else if(!s.isEmpty() && arr[i] < s.peek()) {
                ans[i] = s.peek();
                s.push(arr[i]);
                i--;
            }
        }

        s.printStack();
        System.out.println();
        return ans;
    }

    /**
     * This is the driver code.
     * @param args Unused.
     */
    public static void main(String[] args) {
        int[] arr = {6,8,0,1,3};
        System.out.println(Arrays.toString(method1(arr, 5)));

    }

}
