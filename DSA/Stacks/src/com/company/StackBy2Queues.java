package com.company;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are always pushing a new element in alternative queues but at the end change the name of the queue
 * to q1 and dump all q2 named queue element to q1
 * By doing this recently added elements stay at the top
 */
public class StackBy2Queues {
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();

    //Function to push an element into stack using two queues.
    void push(int a)
    {
        // Your code here
        q1.add(a);
        while(!q2.isEmpty()) q1.add(q2.remove());
        Queue<Integer> q = new LinkedList<Integer>();
        q = q1;
        q1 = q2;
        q2 = q;

        return;
    }

    //Function to pop an element from stack using two queues.
    int pop()
    {
        // Your code here
        if(q2.isEmpty()) return -1;
        return q2.remove();
    }
}
