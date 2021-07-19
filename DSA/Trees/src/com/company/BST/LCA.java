package com.company.BST;

public class LCA {
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

        public Node lowestCommonAncestor(Node root, Node p, Node q) {
            if(root == null) return root;
            if(p.data < root.data && q.data < root.data) return lowestCommonAncestor(root.left, p, q);
            else if(p.data > root.data && q.data > root.data) return lowestCommonAncestor(root.right, p, q);
            else return root;
        }
    }
}
