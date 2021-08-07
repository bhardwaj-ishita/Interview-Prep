package com.company.BST;

public class RangeSum {
    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    class BinaryTree {
        Node root;

        /**
         * this is a brute force
         * here we go to all the nodes and check if lies in the range
         * Time Complexity O(n) where n is the number of nodes
         * @param root
         * @param low
         * @param high
         * @return
         */
        public int brute(Node root, int low, int high) {
            if(root == null) return 0;

            if(root.data >= low && root.data <= high) sum += root.data;
            brute(root.left, low,high);
            brute(root.right, low, high);
            return sum;
        }

        public int sum = 0;

        /**
         * This is an optimization.
         * we'll start the traversal from the root and find if the value doesn't lie in the bracket
         * if root < low we'll go to right side of the tree (where values are bigger than root)
         * if root > high we'll go to left side of the tree (where values are smaller than root)
         * but if the value lies in the bracket we'll add in the sum and send the root to both left and right
         * Time Complexity O(h) where h is the height of the tree
         * @param root
         * @param low
         * @param high
         * @return
         */
        public int rangeSumBST(Node root, int low, int high) {
            if (root == null) return 0;
            if (root.data < low) rangeSumBST(root.right, low, high);//left tree excluded
            if (root.data > high) rangeSumBST(root.left, low, high);//right tree excluded
            if (root.data >= low && root.data <= high) {
                sum += root.data;
                rangeSumBST(root.right, low, high);
                rangeSumBST(root.left, low, high);
            }
            return sum;
        }
    }
}
