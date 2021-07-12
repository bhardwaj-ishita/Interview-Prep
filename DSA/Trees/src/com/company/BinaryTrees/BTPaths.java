package com.company.BinaryTrees;

import java.util.ArrayList;
import java.util.List;

/**
 * the time complexity is O(n) as we are traversing the whole tree
 * but still we can optimize it further by using a stringbuilder instead of a string
 * Strings are immutable hence at every recursion a new string is formed
 * But string builders are mutable and hence the same object is being used in every recursion
 * There it might be thoda complex but we can manipulate the sb after every use.
 *
 * Objects of String are immutable, and objects of StringBuffer and StringBuilder are mutable.
 * StringBuffer and StringBuilder are similar, but StringBuilder is faster and preferred over StringBuffer for the single-threaded program.
 * If thread safety is needed, then StringBuffer is used.
 */
public class BTPaths {

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static class BinaryTree {
        Node root;

        //STRING
        public static List<String> byString(Node root) {
            List<String> list = new ArrayList<String>();
            if(root != null) pathway(root,"",list);
            return list;

        }

        public static void pathway(Node root, String path, List<String> list) {
            if(root.right == null && root.left == null) list.add(path + root.data);
            if(root.left != null) pathway(root.left, path + root.data + "->", list);
            if(root.right != null) pathway(root.right, path + root.data + "->", list);
        }

        //STRING BUILDER
        public static List<String> bySB(Node root) {
            List<String> list = new ArrayList<String>();
            StringBuilder sb = new StringBuilder();
            if(root != null) pathway(root,sb,list);
            return list;

        }

        public static void pathway(Node root, StringBuilder sb, List<String> list) {
            if(root==null) return;
            int length = sb.length();
            sb.append(root.data);
            System.out.println(sb);
            if(root.right == null && root.left == null) {
                System.out.println("sb when leaf node: " + sb);
                list.add(sb.toString());
                System.out.println("list: " + list);
            }
            else {
                sb.append("->");
                pathway(root.left, sb, list);
                System.out.println("pathway: left " + sb);
                pathway(root.right, sb, list);
                System.out.println("pathway: right " + sb);

            }
            sb.setLength(length);
            System.out.println("the end waala sb: " + sb);
        }
    }


    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new Node(4);
        bt.root.left = new Node(6);
        bt.root.right = new Node(3);
        bt.root.left.left = new Node(7);
        bt.root.left.right = new Node(9);

        System.out.println(bt.bySB(bt.root));
    }
}
