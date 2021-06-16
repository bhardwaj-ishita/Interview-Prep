package com.company;

import java.util.Stack;

/**
 * <h1>Minimum Remove to Make Valid Parentheses</h1>
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 *
 * Given a string s of '(' , ')' and lowercase English characters.
 *
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that
 * the resulting parentheses string is valid and return any valid string.
 *
 * Formally, a parentheses string is valid if and only if:
 *
 * It is the empty string, contains only lowercase characters, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 *
 * @author Ishita Bhardwaj
 * @version 11.01
 * @since   2021-06-15
 * */
public class MinRemoves {

    /**
     * This method uses <b>Stacks</b> and a <b>Placeholder</b>
     * As we'll traverse the string, if we find an opening bracket ->
     * save it's index in the stack and move forward
     * now if you find a closing bracket, and the stack is not empty(==that there was an opening bracket before we reached the closing bracket)
     * pop the stack and move forward
     * else if you found a closing bracket and the stack is empty(== there was no opening bracket before it)
     * replace the closing bracket with a * and move forward (This placeholder is to tackle the closing brackets)
     *
     * After you've traversed the whole string
     * check if the stack is empty or not
     * If not, then replace all the saved indexes with * (this placeholder and while statement is to tackle all the opened brackets which were never closed)
     * no replace all * with an empty space and return the string
     *
     * @param string an innput string with imbalanced paranthesis
     * @return string is balanced
     */
    public static String method1(String string) {
        StringBuilder s = new StringBuilder(string);
        Stack<Integer> st = new Stack<>();
        int i = 0;
        for(;i<s.length();i++) {
            if(s.charAt(i) == '(') st.push(i);
            if(s.charAt(i) == ')') {
                if(!st.isEmpty()) st.pop();
                else s.setCharAt(i,'*');
            }
        }
        while(!st.isEmpty()) s.setCharAt(st.pop(),'*');
        return s.toString().replaceAll("\\*", "");
    }

    public static void main(String[] args) {
        String s = "))((";
        System.out.println(method1(s));
    }
}
