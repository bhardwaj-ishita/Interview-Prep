package com.company;

import java.util.ArrayList;

public class SubarraySum {
    public static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
    {
        ArrayList<Integer> list = new ArrayList<>();
        if(s==0) return list;
        int start = 0;
        int end = 0;
        long sum = 0;
        while(end < n) {
            while(sum < s && end < n) {
                sum += arr[end];
                end++;
            }
            while(sum > s) {
                sum -= arr[start];
                start++;
            }
            if(sum==s) {
                list.add(start+1);
                list.add(end);
                return list;
            }
        }
        list.add(-1);
        return list;
    }

    public static void main(String[] args) {
        int[] array = {135,101, 170, 125, 79, 159, 163, 65, 106, 146, 82, 28, 162, 92, 196, 143, 28,
                37, 192, 5, 103, 154, 93, 183, 22, 117, 119, 96, 48, 127, 172, 139, 70, 113, 68, 100,
                36, 95, 104, 12, 123, 134};

        System.out.println(subarraySum(array,42,468));

    }
}
