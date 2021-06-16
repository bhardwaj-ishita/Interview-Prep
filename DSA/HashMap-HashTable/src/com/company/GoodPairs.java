package com.company;

import java.util.HashMap;

/**
 * <h1>Number of Good Pairs</h1>
 * https://leetcode.com/problems/number-of-good-pairs/
 *
 * Given an array of integers nums.
 *
 * A pair (i,j) is called good if nums[i] == nums[j] and i < j.
 *
 * Return the number of good pairs.
 *
 * @author Ishita Bhardwaj
 * @version 11.01
 * @since   2021-06-16
 * */
public class GoodPairs {
    /**
     * This method uses Hash Map
     * Here the key is the integer in the array
     * and value would be the count of that integer
     * As we'll traverse the index, we'll keep saving the integer
     * map.getOrDefault(save the integer,if not already saved then put default value == 0 else give the saved value)+1)
     * simultaneously keep counting the good pairs and remember to remove 1 as the pairs are always one less than the count of the integer
     * @param nums input integer array
     * @return ans the number of good pairs
     */
    public static int method1(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        for(int i : nums) {
            map.put(i,map.getOrDefault(i,0)+1);
            ans += map.get(i)-1;
        }
        return ans;
    }

    /**
     * Just an understandable version of the above method
     * This method uses Hash Map
     * Here the key is the integer in the array
     * and value would be the count of that integer
     * As we'll traverse the index, we'll keep saving the integer
     * If the integer is new then put integer,1 as it has come only once
     * Else if it is already in the hash map, then update the value by 1
     * simultaneously keep counting the good pairs and remember to remove 1 as the pairs are always one less than the count of the integer
     * @param nums input integer array
     * @return ans the number of good pairs
     */
    public static int numIdenticalPairs(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int ans = 0;
        for(int i: nums) {
            if(map.containsKey(i)) map.put(i,map.get(i)+1);
            else map.put(i,1);

            ans += map.get(i) - 1;
        }
        return ans;
    }

    /**
     * This is the main method which makes use of addNum method.
     * @param args Unused.
     */
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,1,3};
        System.out.println(method1(nums));
    }
}
