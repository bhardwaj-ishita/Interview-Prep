package com.company.BST;

import javax.swing.tree.TreeNode;

public class SearchElement {
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

        public Node searchBST(Node root, int val) {
            if(root==null || root.data == val) return root;
            if(val > root.data) return searchBST(root.right, val);
            return searchBST(root.left, val);
        }
    }
}
