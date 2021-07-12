package com.company.BinaryTrees;

public class FindNode {
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

        public boolean findKey(Node root, int key) {
            if(root==null) return false;

            if(root.data == key) return true;

            boolean left = findKey(root.left, key);
            if(left) return left;

            boolean right = findKey(root.right, key);
            return right;

        }
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new Node(4);
        bt.root.left = new Node(6);
        bt.root.right = new Node(3);
        bt.root.left.left = new Node(7);
        bt.root.left.right = new Node(9);

        System.out.println(bt.findKey(bt.root, 9));
    }
}
