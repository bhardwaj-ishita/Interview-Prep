package com.company.BinaryTrees;

public class MaxMinElements {
    public static class Node{
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static class BinaryTree{
        Node root;

        public int minElement(Node root) {
            if(root==null) return Integer.MAX_VALUE;
            int minimum = root.data;
            int left = minElement(root.left);
            int right = minElement(root.right);
            if(left < minimum) minimum = left;
            if(right < minimum) minimum = right;
            return minimum;
        }

        public int maxElement(Node root) {
            if(root==null) return Integer.MIN_VALUE;
            int maximum = root.data;
            int left = maxElement(root.left);
            int right = maxElement(root.right);
            if(left > maximum) maximum = left;
            if(right > maximum) maximum = right;
            return maximum;
        }

    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new Node(4);
        bt.root.left = new Node(6);
        bt.root.right = new Node(3);
        bt.root.left.left = new Node(7);
        bt.root.left.right = new Node(9);

        System.out.println("Minimum: " + bt.minElement(bt.root));
        System.out.println("Maximum: " + bt.maxElement(bt.root));
    }
}
