package com.company;

import java.util.HashSet;

/**
 * <h1>Intersection of Two Arrays</h1>
 * https://leetcode.com/problems/intersection-of-two-arrays/
 *
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must be unique and you may return the result in any order.
 *
 * @author Ishita Bhardwaj
 * @version 11.01
 * @since   2021-06-30
 * */
public class IntersectionOfArrays {

    /**
     * Add all values of num1 in the set and then check if the value of num2 is already in the set
     * If yes then add the value in a seperate set and convert it into an array
     * Time complexity : O(n+m), where n and m are arrays' lengths. O(n) time is used to convert nums1 into
     * set, O(m) time is used to convert nums2, and contains/in operations are O(1) in the average case.
     * Space complexity : O(m+n) in the worst case when all elements in the arrays are different.
     * @param nums1 array 1
     * @param nums2 array 2
     * @return integer array with intersections
     */
    public int[] method1(int[] nums1, int[] nums2) {
        HashSet<Integer> map = new HashSet<>();
        HashSet<Integer> ans = new HashSet<>();
        for(int i:nums1) map.add(i);
        for(int j:nums2) {
            if(map.contains(j)) ans.add(j);
        }

        int[] answer = new int[ans.size()];
        int i = 0;
        for(int x: ans) answer[i++] = x;
        return answer;
    }

    /**
     * This method uses the built-in function retainAll()
     * Time complexity : O(n+m) in the average case and O(n×m) in the worst case when load factor is high enough.
     * Load factor is measure that decides when to increase the HashMap capacity to maintain the get() and put() operation complexity of O(1).
     * The default load factor of HashMap is 0.75f (75% of the map size).
     * Space complexity : O(n+m) in the worst case when all elements in the arrays are different.
     * @param nums1 array 1
     * @param nums2 array 2
     * @return integer array with intersections
     */
    public int[] method2(int[] nums1, int[] nums2) {
        HashSet<Integer> map1 = new HashSet<>();
        HashSet<Integer> map2 = new HashSet<>();
        for(int i:nums1) map1.add(i);
        for(int j:nums2) map2.add(j);

        map1.retainAll(map2);

        int[] answer = new int[map1.size()];
        int i = 0;
        for(int x: map1) answer[i++] = x;
        return answer;
    }

}

