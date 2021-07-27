package com.company;

import java.util.Stack;

/**
 * <h1>Valid Parentheses</h1>
 * https://leetcode.com/problems/valid-parentheses/
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 * @author Ishita Bhardwaj
 * @version 11.01
 * @since   2021-06-14
 * */
public class validParenthesis {

    /**
     * This method uses <b>Stack</b>.
     * Traverse the string and as you find the opening brackets push them in the stack
     * If you find a closing bracket, peek() and see if the closing and opening brackets are pair
     * if not then it's a false parenthesis string
     * After completing the string if the stack is empty then it is a valid string else false
     * space complexity: O(n)
     * time complexity: O(n)
     * @param s Input string
     * @return boolean tells if the input string has complete/valid parenthesis
     */
    public static boolean method1(String s) {
        if(s == null) return true;
        if(s.length() < 2) return false;

        Stack<Character> st = new Stack<>();
        int i = 0;
        while(i < s.length()) {
            if(st.isEmpty() && s.charAt(i) != '(' && s.charAt(i) != '{' && s.charAt(i) != '[') {
                System.out.println("empty and false condition");
                return false;
            }
            else if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                System.out.println("pushed in stack");
                st.push(s.charAt(i));
            }
            else if(!st.isEmpty() && s.charAt(i) != '(' && s.charAt(i) != '{' && s.charAt(i) != '[') {
                System.out.println("not empty and false condition: " + s.charAt(i));
                if(s.charAt(i) == ')' && st.peek() == '(') {
                    System.out.println("() popped");
                    st.pop();
                }
                else if(s.charAt(i) == '}' && st.peek() == '{') {
                    System.out.println("{} popped");
                    st.pop();
                }
                else if(s.charAt(i) == ']' && st.peek() == '[') {
                    System.out.println("[] popped");
                    st.pop();
                }
                else return false;
            }
            i++;
        }
        if(!st.isEmpty()) return false;
        return true;
    }

    /**
     * This method uses <b>Stack</b>.
     * This is much faster version of method 2
     * The aim of the algorithm is almost same
     * it's just the logic has been generalized for all test cases unlike method 1
     * Traverse the string and as you find the opening brackets push their counter closing brackets in the stack
     * If you find a closing bracket, pop() and see if the brackets are same or if the string is empty when it reaches this statement
     * if not then it's a false parenthesis string
     * After completing the string if the stack is empty then it is a valid string else false
     * space complexity: O(n)
     * time complexity: O(n)
     * @param s Input string
     * @return boolean tells if the input string has complete/valid parenthesis
     */
    public static boolean method2(String s) {
        Stack<Character> st = new Stack<>();
        for(char c: s.toCharArray()) {
            if(c=='(') st.push(')');
            else if(c=='{') st.push('}');
            else if(c=='[') st.push(']');
            else if(st.isEmpty() || st.pop() != c) return false;
        }
        return st.isEmpty();
    }

    public static boolean ispar(String x)
    {
        char[] c = x.toCharArray();
        Stack<Character> s = new Stack<>();
        int i = 0;
        while(i < c.length) {
            if(c[i] == '{' || c[i] == '[' || c[i] == '(') {
                s.add(c[i]);
                i++;
                continue;
            }
            if(s.isEmpty()) return false;
            if(c[i] == ')' && s.peek() == '(') s.pop();
            else if(c[i] == '}' && s.peek() == '{') s.pop();
            else if(c[i] == ']' && s.peek() == '[') s.pop();
            else return false;
            i++;
        }

        return s.isEmpty();
    }

    public static void main(String[] args) {
        String s = "(]";
        System.out.println(method2(s));
    }
}
