package com.company.BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

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

        public boolean DFSapproach(Node root) {
            return twoNodes(root.left, root.right);
        }

        public boolean twoNodes(Node left, Node right) {
            if(left == null && right != null) return false;
            if(left != null && right == null) return false;
            if(left == null && right == null) return true;
            if(left.data != right.data) return false;
            return twoNodes(left.left,right.right) && twoNodes(left.right,right.left);
        }

        public boolean BFSapproach(Node root) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            queue.add(root);
            while(!queue.isEmpty()) {
                Node p = queue.poll();
                Node q = queue.poll();
                if(p == null && q == null) continue;
                if(p == null || q == null) return false;
                if(p.data != q.data) return false;
                queue.add(p.left);
                queue.add(q.right);
                queue.add(p.right);
                queue.add(q.left);
            }
            return true;
        }
    }


}
