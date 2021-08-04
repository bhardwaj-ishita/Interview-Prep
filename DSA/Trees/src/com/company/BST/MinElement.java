package com.company.BST;

public class MinElement {
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

        public int minElement(Node node) {
            if(node==null) return Integer.MAX_VALUE;
            int ans = node.data;
            return Math.min(minElement(node.left),ans);
        }
    }
}
