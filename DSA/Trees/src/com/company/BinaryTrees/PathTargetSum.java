package com.company.BinaryTrees;

import java.util.LinkedList;
import java.util.List;

public class PathTargetSum {

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

        public List<List<Integer>> list = new LinkedList<>();
        public List<List<Integer>> pathSum(Node root, int targetSum) {
            if(root==null) return list;
            List<Integer> path = new LinkedList<>();
            int sum = root.data;
            answer(root, targetSum, path, sum);
            return list;
        }
        public void answer(Node root, int target, List<Integer> path, int sum) {
            if(root==null) return;

            path.add(root.data);

            if(root.left==null && root.right==null) {
                if(sum==target) list.add(new LinkedList<>(path));
                return;
            }
            if(root.left!=null) {
                answer(root.left,target,path,sum+root.left.data);
                path.remove(path.size()-1);
            }
            if(root.right!=null) {
                answer(root.right,target,path,sum+root.right.data);
                path.remove(path.size()-1);
            }
        }

    }


}
