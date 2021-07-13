package com.company.BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * This form of traversal is a Breadth-First-Traversal aka Level Order Traversal.
 * This traverses the tree in level order. Prints level 1 then level 2, left to right
 */
public class LevelOrderTraversal {

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

        public List<List<Integer>> list = new ArrayList<>();//the mega list
        public List<List<Integer>> levelOrder(Node root) {
            if(root==null) return list;//if null then return empty mega list
            Queue<Node> nodes = new LinkedList<>();//the queue which will store the current level Node address

            nodes.offer(root);//add the root node pehle se
            //jab tak queue is not empty tab tak continue the loop
            while(!nodes.isEmpty()) {
                List<Integer> level = new ArrayList<>();//create a new level list at each level
                int length = nodes.size();//length decides the size of that particular list

                for(int i = 0; i < length;i++) {
                    Node node = nodes.poll();//empty the queue one by one and queue up the children of this node
                    level.add(node.data);//add the emptied node value in the level list
                    if(node.left!=null) nodes.offer(node.left);//add the left node of the root to queue
                    if(node.right!=null) nodes.offer(node.right);//add the right node of the root to queue
                }
                //at this point the queue is full of the children of the nodes i.e the next level
                //the level list is full of the current level nodes
                list.add(level);//we'll add the level list to the mega list
                // and start all over again with a new level list of the next level
            }

            return list;
        }
    }

}
