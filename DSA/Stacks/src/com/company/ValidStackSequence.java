package com.company;

/**
 * <h1>Valid Stack Sequence</h1>
 * https://leetcode.com/problems/validate-stack-sequences/
 *
 * Given two sequences pushed and popped with distinct values, return true if and only if this could
 * have been the result of a sequence of push and pop operations on an initially empty stack.
 *
 * @author Ishita Bhardwaj
 * @version 11.01
 * @since   2021-06-14
 * */
public class ValidStackSequence {

    /**
     * This method uses <b>Stack</b>.
     * We'll start pushing the pushed array into the stack
     * and simultaneously we'll check if the pushed number is equal to the popped array
     * if true, then pop the stack out and move forward
     * space complexity: O(n)
     * time complexity: O(n)
     * @param pushed input integer array
     * @param popped input integer array
     * @return boolean tells if the push-pop act is possible
     */
    public static boolean method1(int[] pushed, int[] popped) {
        Stack s = new Stack();
        int i = 0, j = 0;
        while(i < pushed.length && j < popped.length) {
            s.push(pushed[i++]);
            System.out.println("i: " + i);
            while(!s.isEmpty() && s.peek() == popped[j]) {
                System.out.println("j: " + j);
                System.out.println("popped: " + s.peek());
                s.pop();
                j++;
            }
        }
        return s.isEmpty();
    }

    public static void main(String[] args) {
        int[] push = {1,2,3,4,5};
        int[] pop = {4,5,3,2,1};
        System.out.println(method1(push,pop));
    }
}
