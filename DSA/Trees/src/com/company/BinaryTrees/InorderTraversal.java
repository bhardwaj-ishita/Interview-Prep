package com.company.BinaryTrees;

import java.util.ArrayList;
import java.util.List;

/**
 * whichever node comes. first recursion occurs to it's left and then prints the root and goes to right
 * Left -> Root -> Right
 */
public class InorderTraversal {
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

        public List<Integer> inorderTraversal(Node root) {
            list = new ArrayList<Integer>();
            iT(root);
            return list;
        }
        public List<Integer> list;
        public void iT(Node root) {
            if(root== null) return;
            iT(root.left);
            list.add(root.data);
            iT(root.right);
        }
    }

}
