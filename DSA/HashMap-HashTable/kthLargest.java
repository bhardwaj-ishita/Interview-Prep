package com.company;

import com.company.PriorityQueue.MaxPriorityQueue;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;


public class kthLargest {/**
 * <h1>Kth Largest Element in an Array</h1>
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 *
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * @author Ishita Bhardwaj
 * @version 11.01
 * @since   2021-06-27
 * */

    /**
     * There are 3 approaches to solve this problem
     * First use O(n log n) Sorting methods like quick sort or heap sort
     * Second use Max-Heap. It will take O(n log n) time too
     * Third use Quick Select Algorithm. in worst case scenerio it might take O(n2) but average times it take O(n) too
     * I've used priority queue
     * @param nums int array
     * @param k the index of the element we need to return
     * @return the kth largest number in the array
     */
    public static int method1(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i: nums) pq.add(i);
        while(k-- > 1) pq.poll();
        return pq.remove();
    }

    /**
     * This is part of method 2: QUICKSELECT ALGORITHM
     * the logic is simple. take pivot and arrange smaller values to one side and larger to other
     * at the end put the pivot at the divisor of the array
     * if pivot is equal to k then return
     * if pivot is greater than k then do the method again for the array from low to start-1
     * if pivot is smaller than k then do the method again for the array from start+1 to high
     * @param nums
     * @param k
     * @return
     */
    public int method2(int[] nums, int k) {
        if(nums==null || nums.length == 0) return Integer.MAX_VALUE;
        return partition(nums, nums.length - 1, 0, k-1);
    }

    public int partition(int[] nums,int high, int low, int k) {
        if(low > high) return Integer.MAX_VALUE;
        System.out.println("k: " + k);
        int pivot = high;
        int start = low, i = low;
        while(i < pivot) {
            if(nums[i] >= nums[pivot]) swap(start++,i,nums);
            System.out.println(Arrays.toString(nums));
            i++;
        }
        swap(start,i,nums);

        System.out.println(Arrays.toString(nums));
        System.out.println("start: " + start);

        if(start < k) return partition(nums, high, start+1, k);
        else if(start > k) return partition(nums, start-1, low, k);
        return nums[start];
    }

    public void swap(int i, int high, int[] nums) {
        int temp = nums[high];
        nums[high] = nums[i];
        nums[i] = temp;
    }

    public static int method3(int[] nums, int k) {
        MaxPriorityQueue mh = new MaxPriorityQueue();
        int i = 0;
        while(i < nums.length) {
            Integer number = Integer.valueOf(nums[i]);
            mh.add(number);
            i++;
        }
        System.out.println(mh);
        while(k-->0) mh.poll();
        return mh.poll();
    }

    /**
     * This is the main method which makes use of addNum method.
     * @param args Unused.
     */
    public static void main(String[] args) {
        int[] nums = {5,2,3,4,6,1, 5,73, 34};
        System.out.println(method3(nums, 3));
    }
}
