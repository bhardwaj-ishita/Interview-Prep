package com.company.BST;

public class InsertElement {

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

        public Node insertIntoBST(Node root, int val) {
            if(root==null) return new Node(val);
            if(root.data < val) root.right = insertIntoBST(root.right, val);
            else root.left = insertIntoBST(root.left, val);
            return root;
        }
    }
}
