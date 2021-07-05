package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
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
public class kthLargest {

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

    public static int partition(int low, int high, int k, int[] nums) {
        System.out.println("I'm in partition");
        //both pivot and i are on index 0
        //if i<=high -> swap and pivot++ i++
        //if i > high -> i++
        //there are three regions: 0 to (j-1) == larger && j to (i - 1) == smaller && i to rest == unknown
        //here i is iterator and pivot is the division
        int pivot = low;
        for(int i = low; i < high; i++) {
            System.out.println("I'm in loop");
            if(nums[i] <= nums[high]) {
                swap(nums, i, high);
                pivot++;
                System.out.println(Arrays.toString(nums) + " pivot: " + nums[pivot] + " i: " + nums[i]);
            }
        }
        if(pivot < k) partition(pivot,high-1, k, nums);
        else if(pivot >  k) partition(0, pivot - 1, k, nums);
        return nums[k-1];
    }

    public static void swap(int[] nums, int pivot, int i) {
        int temp = nums[pivot];
        nums[pivot] = nums[i];
        nums[i] = temp;
        return;
    }

    public static int method2(int[] nums, int k) {
        System.out.println("I'm in method 2");
        return partition(0,nums.length-1,k,nums);
    }

    /**
     * This is the main method which makes use of addNum method.
     * @param args Unused.
     */
    public static void main(String[] args) {
        int[] nums = {5,2,3,4,6,1, 5,73, 34};
        System.out.println(method2(nums, 3));
    }
}
