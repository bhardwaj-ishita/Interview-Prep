package com.company.BinaryTrees;

import java.util.ArrayList;
import java.util.List;

/**
 * whichever node comes. first prints the root and then the recursion occurs to it's left and as it reaches a null
 * recursion goes to the roots right
 * Root -> Left -> Right
 */
public class PreorderTraversal {
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
            preOrder(root);
            return list;
        }
        public List<Integer> list;
        public void preOrder(Node root) {
            if(root== null) return;
            list.add(root.data);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

}
