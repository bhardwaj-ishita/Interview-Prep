package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;


//Time complexity: O(n^2*(n!))
public class Permutation {
    public List<String> find_permutation(String s) {
        List<String> list = new ArrayList<>();
        permute(s, 0, s.length()-1, list);
        Collections.sort(list);//for the lexicographical order
        return list;
    }

    public HashSet<String> set = new HashSet<>();
    public void permute(String s, int start, int end, List<String> list) {
        if (start == end) {
            if(!set.contains(s)) {
                set.add(s);//to avoid duplicates
                list.add(s);
            }
        }
        else{
            for(int i = start; i <= end; i++) {
                s = swap(s,start,i);
                permute(s, start + 1, end, list);
                s = swap(s,start,i);//to backtrack
            }
        }
    }

    public String swap(String s, int i, int j) {
        char temp;
        char[] charArray = s.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
