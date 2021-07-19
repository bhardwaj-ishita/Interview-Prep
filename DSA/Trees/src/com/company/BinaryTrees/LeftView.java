package com.company.BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftView {
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

        //Preorder Traversal
        public List<Integer> rightSideView(Node root) {
            List<Integer> ans = new ArrayList<Integer>();
            DFS(root,ans,0);
            return ans;
        }
        public void DFS(Node root, List<Integer> ans, int level) {
            if(root == null) return;

            if(level == ans.size()) {
                ans.add(root.data);
            }

            DFS(root.left, ans, level+1);
            DFS(root.right, ans, level+1);
        }

        //Level Order Traversal : add the last node in the queue to the list of that level
        public List<Integer> BFS(Node root) {
            List<Integer> ans = new ArrayList<Integer>();
            if(root==null) return ans;
            Queue<Node> q = new LinkedList<Node>();
            q.offer(root);
            while(!q.isEmpty()) {
                int size = q.size();
                while(size-->0) {
                    Node curr = q.poll();
                    if(size==0) ans.add(curr.data);
                    if(curr.right!=null)q.offer(curr.right);
                    if(curr.left!=null)q.offer(curr.left);
                }
            }

            return ans;
        }


    }
}
