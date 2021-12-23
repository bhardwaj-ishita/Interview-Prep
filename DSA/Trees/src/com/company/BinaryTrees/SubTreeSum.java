package com.company.BinaryTrees;

public class SubTreeSum {

    /**
     * In counting sum of the subtree we want to start from the bottom after we've reached root -> left -> right
     * Plus we need to send the sum of the smaller sub tree to the larger sub tree
     *
     * so we start from the root iterate to the left and then right and add the root, left and right and compare the sum
     * then we return the sum to the larger sub tree and look in the next larger subtree if the sum is equal to X
     */

    public static int ans = 0;
    public static int countSubtreesWithSumX(SumOfBT.Node root, int x) {
        if(root==null)return 0;

        int left = countSubtreesWithSumX(root.left,x);
        int right = countSubtreesWithSumX(root.right,x);
        int sum = root.data + left + right ;

        if(sum == x) ans++;

        return sum;
    }

}
