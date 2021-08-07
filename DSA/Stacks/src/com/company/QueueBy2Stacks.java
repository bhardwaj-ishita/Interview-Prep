package com.company;

import java.util.Stack;

/**
 * The main task is to either make pop O(1) and push O(n)
 * OR make pop O(n) and push O(1)
 */
public class QueueBy2Stacks {


    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    //Function to push an element in queue by using 2 stacks.
    void Push(int x)
    {
        if(s1.isEmpty()) {
            while(!s2.isEmpty()) s1.push(s2.pop());
        }
        s1.push(x);

        if(s2.isEmpty()) {
            while(!s1.isEmpty()) s2.push(s1.pop());
        }

        return;
    }


    //Function to pop an element from queue by using 2 stacks.
    int Pop()
    {
        if(s2.isEmpty()) return -1;

        return s2.pop();
    }
}
