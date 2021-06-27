package com.company;

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
     * Third use Quick Sort. in worst case scenerio it might take O(n2) but average times it take O(n) too
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
}
