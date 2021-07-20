package com.company;

import java.util.HashMap;
import java.util.Map;

public class TwoSums {

    //Using iteration (brute force) O(N^2)
    public int[] bruteForce(int[] nums, int target) {
        int[] indices = new int[2];
        for(int i = 0; i < nums.length; i++) {
            int j = i + 1;
            while(j < nums.length) {
                if(nums[i] + nums[j] == target) {
                    indices[0] = i;
                    indices[1] = j;
                }
                j++;
            }
        }
        return indices;
    }

    //Using HashMap O(N)
    public int[] hashing(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for(int i = 0; i < nums.length;i++) {
            if(map.containsKey(target-nums[i])) {
                ans[0] = i;
                ans[1] = map.get(target-nums[i]);
                return ans;
            }
            map.put(nums[i], i);
        }

        return ans;
    }
}
