package com.company;

/**
 * <h1>Gray Code: Daily Challenge</h1>
 * https://leetcode.com/problems/gray-code/
 *
 * An n-bit gray code sequence is a sequence of 2n integers where:
 *
 * Every integer is in the inclusive range [0, 2n - 1],
 * The first integer is 0,
 * An integer appears no more than once in the sequence,
 * The binary representation of every pair of adjacent integers differs by exactly one bit, and
 * The binary representation of the first and last integers differs by exactly one bit.
 * Given an integer n, return any valid n-bit gray code sequence.
 *
 * Gray Code: two successive values differ by 1 bit
 *
 * it has a pattern:
 * at 0th bit 0110
 * at 1st bit 00111100
 * at 2nd bit 0000111111110000
 * at 3rd bit 00000000111111111111111100000000
 *
 * @author Ishita Bhardwaj
 * @version 11.01
 * @since   2021-07-2
 * */
public class GrayCode {

    /**
     * This method uses BACKTRACKING
     * Backtracking is a method to find solutions and eliminate as we go.
     * It is similar to tree traversal
     * We start from the root node and go down to the child nodes.
     * If the child node gives a partial solution then we go further down to it's child node
     * If the child node is not a potential answer, we BACKTRACK and abandon any further solutions under that child node
     * At the end all the potential solutions are the leaf nodes.
     *
     *
     * larger the number bits, that much deep the recursive stack would be
     *
     * we take 0 1 == original and reverse == 1 0
     * add 0 to original and 1 to reverse and join them to make an original (n=1)
     * original == 00 01 11 10 and reverse == 10 11 01 00
     * again add 0 to original and 1 to reverse and join them to make an original (n=2)
     * and go on until you've reached the nth bit.
     */
    public static void method1() {

    }
}
