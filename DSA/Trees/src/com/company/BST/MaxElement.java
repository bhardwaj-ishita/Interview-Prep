package com.company.BST;

public class MaxElement {

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

        public static int maxElement(Node node) {
            if(node==null) return Integer.MAX_VALUE;
            int ans = node.data;
            return Math.max(maxElement(node.right),ans);
        }
    }

}
