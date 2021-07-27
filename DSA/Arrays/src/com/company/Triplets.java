package com.company;

import java.util.HashSet;

public class Triplets {
    public static int countTriplet(int arr[], int n) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : arr) set.add(i);
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                int sum = arr[i] + arr[j];
                if(set.contains(sum)) count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr = {1,5,3,2};
        System.out.println(countTriplet(arr,4));
    }

}
