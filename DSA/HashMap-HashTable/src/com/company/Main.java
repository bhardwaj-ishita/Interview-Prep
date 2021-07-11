package com.company;

import com.company.PriorityQueue.MaxPriorityQueue;

import java.util.Arrays;

/**
 * <h1>Next Greater Node In Linked List</h1>
 * https://leetcode.com/problems/next-greater-node-in-linked-list/
 *
 * We are given a linked list with head as the first node.
 * Let's number the nodes in the list: node_1, node_2, node_3, ... etc.
 *
 * Each node may have a next larger value: for node_i, next_larger(node_i) is the node_j.val such that j > i,
 * node_j.val > node_i.val, and j is the smallest possible choice.
 * If such a j does not exist, the next larger value is 0.
 *
 * Return an array of integers answer, where answer[i] = next_larger(node_{i+1}).
 *
 * Note that in the example inputs (not outputs) below, arrays such as [2,1,5] represent the serialization of
 * a linked list with a head node value of 2, second node value of 1, and third node value of 5.
 *
 * @author Ishita Bhardwaj
 * @version 11.01
 * @since   2021-06-4
 * */
public class Main {

    /**
     * This is a <b>Naive Method</b>.
     * Here we uses two loops to itterate the head and another tp compare all the node.data with the head pointer to find the next greater value
     * space complexity: O(n)
     * time complexity: O(n^2)
     * @param head The parameter is used to point at the head of an input linked list
     * @return int[] This array gives all the next greater values respectively with all the node position
     */

    /**
     * This is the main method which makes use of addNum method.
     * @param args Unused.
     */
    public static void main (String[] args)
    {
        // create a priority queue with an initial capacity of 10.
        // The value of an element decides the priority of it.
        MaxPriorityQueue pq = new MaxPriorityQueue();

        // insert three integers
        pq.add(3);
        pq.add(2);
        pq.add(15);

        // print priority queue size
        System.out.println("Priority queue size is " + pq.size());

        // search 2 in priority queue
        Integer searchKey = 2;

        if (pq.contains(searchKey)) {
            System.out.println("Priority queue contains " + searchKey + "\n");
        }

        // empty queue
        pq.clear();

        if (pq.isEmpty()) {
            System.out.println("The queue is empty");
        }

        System.out.println("\nCalling remove operation on an empty heap");
        System.out.println("The element with the highest priority is " + pq.poll());

        System.out.println("\nCalling peek operation on an empty heap");
        System.out.println("The element with the highest priority is " + pq.peek() +
                System.lineSeparator());

        // again insert three integers
        pq.add(5);
        pq.add(4);
        pq.add(45);

        // construct an array containing all elements present in the queue
        Integer[] I = pq.toArray();
        System.out.println("Printing array: " + Arrays.toString(I));

        System.out.println("\nThe element with the highest priority is " + pq.poll());
        System.out.println("The element with the highest priority is " + pq.peek());
    }
}