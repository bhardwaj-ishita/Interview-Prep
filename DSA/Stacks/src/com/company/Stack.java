package com.company;

public class Stack {
    StackNode root;

    public void push(long l) {
    }

    static class StackNode {
        int data;
        StackNode next;

        StackNode(int data) {
            this.data = data;
        }
    }

    boolean isEmpty() {return root==null;}

    void push(int data) {
        StackNode newNode = new StackNode(data);
        StackNode temp = root;
        root = newNode;
        newNode.next = temp;
        System.out.println(data + " pushed");
    }

    int pop() {
        int popped = Integer.MIN_VALUE;
        if(this.isEmpty()) {
            System.out.println("Stack is Empty");
            return popped;
        }
        popped = root.data;
        root = root.next;
        return popped;
    }

    int peek() {
        if(this.isEmpty()) {
            System.out.println("Stack is Empty");
            return Integer.MIN_VALUE;
        }
        return root.data;
    }

    void printStack() {
        if(this.isEmpty()) {
            System.out.println("Stack UnderFlow");
            return;
        }
        StackNode iter = root;
        System.out.println("The stack: ");
        while(iter != null) {
            System.out.print(iter.data + " ");
            iter = iter.next;
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);

        System.out.println(s.pop() + " is popped from the stack");
        System.out.println("Is the stack empty: " + s.isEmpty());
        System.out.println(s.peek());
        s.printStack();
    }

}
