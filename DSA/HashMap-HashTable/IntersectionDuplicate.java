package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class IntersectionDuplicate {

    public int[] method1(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> set = new ArrayList<Integer>();
        for (int i : nums1) map.put(i, map.getOrDefault(i, 0) + 1);
        for (int j : nums2) {
            if (map.containsKey(j) && map.get(j) > 0) {
                map.put(j, map.get(j) - 1);
                set.add(j);
            }
        }
        int[] ans = new int[set.size()];
        for (int i = 0; i < set.size(); i++) {
            ans[i] = set.get(i);
        }
        return ans;
    }

    public int[] method2(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> set = new ArrayList<>();
        for (; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] < nums2[j]) i++;
            else if (nums1[i] > nums2[j]) j++;
            else if (nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] ans = new int[set.size()];
        for (int x = 0; x < set.size(); x++) {
            ans[x] = set.get(x);
        }
        return ans;
    }

    public int[] method3(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int size = nums1.length > nums2.length ? nums2.length: nums1.length;
        int[] ans = new int[size];
        int x = 0;
        for(int i:nums1) map.put(i,map.getOrDefault(i,0)+1);
        for(int j:nums2) {
            if(map.containsKey(j) && map.get(j)>0) {
                map.put(j,map.get(j)-1);
                ans[x++] = j;
            }
        }

        return Arrays.copyOfRange(ans,0,x);
    }
}
