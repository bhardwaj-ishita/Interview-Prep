package com.company;

import java.util.Arrays;
import java.util.Stack;

/**
 * <h1>Asteroid Collision</h1>
 * https://leetcode.com/problems/asteroid-collision/
 *
 * We are given an array asteroids of integers representing asteroids in a row.
 *
 * For each asteroid, the absolute value represents its size, and the sign represents its direction
 * (positive meaning right, negative meaning left).
 * Each asteroid moves at the same speed.
 *
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller
 * one will explode. If both are the same size, both will explode. Two asteroids moving in the same
 * direction will never meet.
 *
 * @author Ishita Bhardwaj
 * @version 11.01
 * @since   2021-06-15
 * */
public class AsteroidCollision {

    /**
     * Here we of course use stack
     * We run the loop till we've traversed the whole array
     * For collision to happen we want the asteroids to be in different directions.
     * The only difficult thing here is when to push the stack
     * The only time we have to push in the stack is when the conditions in the while loop are false
     * If the index has gone in the while loop then after it breaks from the loop it shouldn't be pushed.
     * Hence we've used the break label tag
     * @param a input array
     * @return ans is the after collision array. This algorithm is not in-place
     */
    public static int[] method1(int[] a) {
        Stack<Integer> stack = new Stack();
        for (int ast: a) {
            collision: {
                while (!stack.isEmpty() && ast < 0 && 0 < stack.peek()) {
                    if (stack.peek() < -ast) {
                        stack.pop();
                        continue;
                    } else if (stack.peek() == -ast) {
                        stack.pop();
                    }
                    break collision;
                }
                stack.push(ast);
            }
        }

        int[] ans = new int[stack.size()];
        for (int t = ans.length - 1; t >= 0; --t) {
            ans[t] = stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {2,1,1,-2};
        System.out.println(Arrays.toString(method1(a)));
    }
}