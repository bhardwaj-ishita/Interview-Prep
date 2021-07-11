package com.company;

public class BinaryTreeSize {
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

        public int size() {
            return size(root);
        }

        public int size(Node node) {
            if(node==null) return 0;
            return size(node.left) + 1 + size(node.right);
        }

    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new Node(1);
        bt.root.left = new Node(2);
        bt.root.right = new Node(3);
        bt.root.left.left = new Node(4);
        bt.root.left.right = new Node(5);

        System.out.println(bt.size());
    }
}
