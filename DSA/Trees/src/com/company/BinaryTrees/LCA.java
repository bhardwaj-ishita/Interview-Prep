package com.company.BinaryTrees;


public class LCA {
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

        /**
         * postorder traversal
         * we'll go down the subtrees and jaise hi you find either p or q, the sub tree left/right becomes true
         * as mid = 1 and and we'll only get an answer if we get
         */
        public Node lowestCommonAncestor(Node root, Node p, Node q) {
            answer(root,p,q);
            return answer;
        }

        public Node answer;
        public boolean answer(Node root, Node p, Node q) {
            if(root==null) return false;

            int left = answer(root.left,p,q)?1:0;
            int right = answer(root.right,p,q)?1:0;
            int mid = (root == p || root == q)?1:0;
            if(mid+left+right>=2) answer = root;

            //will start backtracking as we start finding p or q
            return (mid+left+right>0);
        }


    }

}
