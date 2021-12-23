package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an infinite supply of each denomination of Indian currency { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 }
 * and a target value N.
 * Find the minimum number of coins and/or notes needed to make the change for Rs N.
 */
public class MinCoins {
    public static List<Integer> minPartition(int n)
    {
        List<Integer> ans = new ArrayList<>();
        int[] deno = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
        for(int i = deno.length-1; i >= 0 && n >=0; i--) {
            while(n>=deno[i]) {
                n = n-deno[i];
                ans.add(deno[i]);
            }
        }
        return ans;
    }
}
