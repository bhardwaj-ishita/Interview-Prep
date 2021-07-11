package com.company.BinaryTrees;

public class BinaryTreeHeight {
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

        public int maxDepth(Node node) {
            if(node==null) return 0;
            return Math.max(maxDepth(node.left),maxDepth(node.right))+1;
        }

        public int minDepth(Node root) {
            if(root==null) return 0;
            int left = minDepth(root.left);
            int right = minDepth(root.right);
            return (left == 0 || right == 0)? Math.max(left,right)+1 :Math.min(left,right)+1;
        }

    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new Node(1);
        bt.root.left = new Node(2);
        bt.root.left.left = new Node(4);
        bt.root.left.right = new Node(5);
        bt.root.left.right.left = new Node(4);
        bt.root.left.right.right = new Node(5);
        bt.root.left.right.right.left = new Node(5);
        bt.root.left.right.right.right = new Node(5);
        bt.root.left.right.right.right.left = new Node(5);

        System.out.println(bt.maxDepth(bt.root));
        System.out.println(bt.minDepth(bt.root));
    }
}
