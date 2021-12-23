package com.company;

import java.util.HashMap;
import java.util.Map;


public class Anagrams {

    /**
     * Three methods to do this algo:
     * Method 1: O(nlogn) for sorting Arrays.sort(string)
     *      take the strings compare their size if equal great else false
     *      then sort them and iterate them and compare
     *
     * Method 2: O(n) space and time
     *      take the strings compare their size if equal great else false
     *       make two arrays[256] and count++ each and compare values
     *
     * Method 2: O(n) time and optimized space
     *      take the strings compare their size if equal great else false
     *      make one array[256] and count++ each for string 1 and count-- for string 2
     *      if values at the end is 0 for all then true
     *
     *      you can use a hash map for this purpose too
     *
     *
     * @param A
     * @param B
     * @return
     */
    //Function is to check whether two strings are anagram of each other or not.
    public static boolean isAnagram(String A,String B)
    {
        if(A.length() != B.length()) return false;

        char[] a = A.toCharArray();
        char[] b = B.toCharArray();

        Map<Character , Integer> map = new HashMap<>();

        for(int i = 0 ; i < a.length ; i++) {
            map.put(a[i], map.getOrDefault(a[i],0)+1);
        }

        //for(Character charac: map.keySet()) System.out.println(charac + " " + map.get(charac));

        for(int i = 0 ; i < b.length ; i++) {
            if(!map.containsKey(b[i])) return false;

            map.put(b[i], map.getOrDefault(b[i],0)-1);
        }

        //for(Character charac: map.keySet()) System.out.println(charac + " " + map.get(charac));

        for (Character key : map.keySet()) {
            if(map.get(key) != 0) return false;
        }

        return true;

    }
}
