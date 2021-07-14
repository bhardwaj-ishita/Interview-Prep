package com.company.BinaryTrees;

public class PathSum {

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

        public boolean hasPathSum(Node root, int targetSum) {
            if(root==null) return false;
            return sum(root, targetSum, 0);
        }

        public boolean sum(Node root, int targetSum ,int path) {
            if(root.right == null && root.left== null) {
                path+=root.data;
                return(path==targetSum);
            }
            return (root.left != null && sum(root.left, targetSum, path + root.data))
                    || (root.right != null && sum(root.right, targetSum, path + root.data));
        }
    }

}
