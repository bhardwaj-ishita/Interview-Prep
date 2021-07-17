package com.company.BinaryTrees;

public class DiameterBT {

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

        //NOT A GOOD APPROACH
        public int ans = 0;;
        public int badSol(Node root) {
            if(root==null) return 0;
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            ans = Math.max(ans, left+right);
            badSol(root.left);
            badSol(root.right);
            return ans;
        }

        public int maxDepth(Node root) {
            if(root==null) return 0;
            return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
        }

        //BEST SOLUTION TIME COMPLEXITY WISE: traverse the nodes only once and when any root gets the numbers
        //store it in ans and keep checking for a max value at a root. and return the answer
        public int answer = 0;
        public int BestSol(Node root) {
            if(root==null) return 0;
            maxDepth(root);
            return answer;
        }

        public int maxDepthOpt(Node root) {
            if(root==null) return 0;
            int left = maxDepthOpt(root.left);
            int right = maxDepthOpt(root.right);
            ans = Math.max(ans, left+right);
            return Math.max(left,right)+1;
        }
    }

}
