package com.company.BinaryTrees;

/**
 * in the FIND THE NUMBER OF NODES as we traverse the tree we keep adding 1 for the count of the current node
 * Similarly here as we traverse the tree we'll keep on adding the node.data to return the sum of the nodes
 */
public class SumOfBT {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static class BinaryTree {
        Node root;

        public int sum(Node root) {
            if(root==null) return 0;
            return sum(root.left) + sum(root.right) + root.data;
        }

    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new Node(4);
        bt.root.left = new Node(6);
        bt.root.right = new Node(3);
        bt.root.left.left = new Node(7);
        bt.root.left.right = new Node(9);

        System.out.println(bt.sum(bt.root));
    }
}
