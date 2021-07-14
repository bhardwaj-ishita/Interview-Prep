package com.company.BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBT {

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

        public Node invertTree(Node root) {
            if (root == null) return root;
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                Node current = queue.poll();
                Node temp = current.left;
                current.left = current.right;
                current.right = temp;
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            return root;
        }
    }
}
