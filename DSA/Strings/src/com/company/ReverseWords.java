package com.company;

public class ReverseWords {

    //use string builder for an optimized version
    public static String reverseWords(String s)
    {
        String[] str = s.split("\\.");
        StringBuilder ans = new StringBuilder();
        int j = str.length-1;
        while(j>=0) {
            ans.append(str[j]).append(".");
            j--;
        }

        ans.toString();
        int x = ans.length();
        return ans.substring(0,x-1);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("i.like.programming.much"));
    }
}
