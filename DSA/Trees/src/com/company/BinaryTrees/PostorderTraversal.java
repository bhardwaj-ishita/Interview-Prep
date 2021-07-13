package com.company.BinaryTrees;

import java.util.ArrayList;
import java.util.List;

/**
 * whichever node comes. first recursion occurs to it's left and as we reach null
 * it prints the root.left's root.right then prints the root
 * Left -> Right -> Root
 */
public class PostorderTraversal {
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

        public List<Integer> preorderTraversal(Node root) {
            list = new ArrayList<Integer>();
            postOrder(root);
            return list;
        }
        public List<Integer> list;
        public void postOrder(Node root) {
            if(root== null) return;
            list.add(root.data);
            postOrder(root.left);
            postOrder(root.right);
        }
    }
}
