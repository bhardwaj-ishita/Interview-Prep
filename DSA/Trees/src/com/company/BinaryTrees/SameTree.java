package com.company.BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {
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

        //DFS
        public boolean isSameTreeDFS(Node p, Node q) {
            if(p==null && q!=null)return false;
            if(p!=null && q==null)return false;
            if(p==null && q==null)return true;

            boolean bool = false;
            if(p.data != q.data) return false;
            bool = isSameTreeDFS(p.left,q.left) && isSameTreeDFS(p.right,q.right);

            return bool;
        }

        //BFS
        public boolean isSameTreeBFS(Node p, Node q) {
            if(!check(p,q)) return false;
            Queue<Node> queue = new LinkedList<>();
            queue.offer(p);
            queue.offer(q);
            while(!queue.isEmpty()) {
                Node first = queue.poll();
                Node second = queue.poll();
                if(!check(first,second)) return false;
                if(first == null && second == null) continue;//to stop going to null nodes
                queue.offer(first.left);
                queue.offer(second.left);
                queue.offer(first.right);
                queue.offer(second.right);
            }
            return true;
        }

        public boolean check(Node p, Node q) {
            if(p==null && q!=null)return false;
            if(p!=null && q==null)return false;
            if(p==null && q==null)return true;
            if(p.data != q.data) return false;
            return true;
        }
    }
}
