package com.company.BinaryTrees;

public class SecondMinElement {
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

        public static int minVal;
        public static long ans = Long.MAX_VALUE;

        public void answer(Node root) {
            if(root == null) return;
            if(root.data > minVal && root.data < ans) ans = root.data;
            else if(root.data == minVal) {
                answer(root.left);
                answer(root.right);
            }
        }

        public int secondMinElement(Node node) {
            if(node==null) return 0;
            minVal = node.data;
            answer(node);
            return ans < Long.MAX_VALUE ? (int) ans : -1;
        }
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new Node(4);
        bt.root.left = new Node(6);
        bt.root.right = new Node(3);
        bt.root.left.left = new Node(7);
        bt.root.left.right = new Node(9);

        System.out.println(bt.secondMinElement(bt.root));
    }
}
