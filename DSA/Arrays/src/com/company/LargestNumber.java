package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

    /**
     * Here the function wants has an input String array and we need to sort it out to get a largest number as output
     * 34 > 3 > 30
     * here we'll take x and y and compare xy to yx and see which is a bigger number.
     * That will be the basis of our sorting logic.
     *
     * We thus use a user defined sorting function using a comparator.
     * The requirement is Time : O(nlogn)
     *                      Space : O(1)
     *
     * "@Override_" annotation is used to prevent error when a subclass has a same method as declared in the parent class
     * Here we've made our own compare function in Arrays.sort() whereas the original inbuilt parent class also has a Arrays.sort
     * compare method. Hence we are overriding that parent class function and using our user defined method i.e. over writing
     * it's base class method.
     *
     *
     * Even if the input is an array we can only use the string for comparator for comparison purpose as integers will
     * just add
     *
     * @param arr
     * @return
     */
    public String printLargest(String[] arr) {

        Arrays.sort(arr, new Comparator<String>() {
            @Override public int compare(String X, String Y) {
                String XY = X + Y;
                String YX = Y + X;
                return XY.compareTo(YX) > 0 ? -1 : 1;
                //by default sorting is for ascending order. by putting -1 for true
                // we are making it descending i.e the bigger number is given the priority
            }
        });

        if(arr[0].equals("0")) return "0"; // this is an important condition which was missed in gfg (00 != 0)

        String ans = "";
        for(String i: arr) ans += i;
        return ans;
    }
}
