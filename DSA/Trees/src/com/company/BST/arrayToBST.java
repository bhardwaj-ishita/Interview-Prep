package com.company.BST;

public class arrayToBST {
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

        public Node sortedArrayToBST(int[] nums) {
            if(nums.length==0) return null;
            return answer(nums, 0, nums.length-1);
        }

        public Node answer(int[] nums, int start, int end) {
            if(start > end) return null;
            int mid = (start + end)/2;
            Node root = new Node(nums[mid]);
            root.left = answer(nums, start, mid-1);
            root.right = answer(nums, mid+1, end);
            return root;
        }
    }
}
