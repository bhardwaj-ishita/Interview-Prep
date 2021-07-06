package com.company.PriorityQueue;

import java.util.Vector;

public class MinPriorityQueue {

    public Vector<Integer> A;

    public MinPriorityQueue() {
        A = new Vector<>();
    }

    public MinPriorityQueue(int capacity) {
        A = new Vector<>(capacity);
    }

    //return parent of i
    public int parent(int i) {
        if(i==0) return 0;
        return (i-1)/2;
    }

    //return left child of i
    public int LEFT(int i) {
        return (2*i + 1);
    }

    //return right child
    public int RIGHT(int i) {
        return (2*i + 2);
    }

    //swap value of two indexes
    public void swap(int x, int y) {
        Integer temp = A.get(x);
        A.setElementAt(A.get(y), x);
        A.setElementAt(temp,y);
    }

    public int size() {
        return A.size();
    }

    public boolean isEmpty() {
        return A.isEmpty();
    }

    public boolean contains(int i) {
        return A.contains(i);
    }

    public Integer[] toArray() {
        return A.toArray(new Integer[size()]);
    }

    public void heapify_up(int i) {
        if(i > 0 && A.get(i) < A.get(parent(i))) swap(i, parent(i));
        heapify_up(parent(i));
    }

    public void heapify_down(int i) {
        int left = LEFT(i);
        int right = RIGHT(i);
        int largest = i;

        if(i>0 && A.get(i) > A.get(left)) largest = left;
        if(i>0 && A.get(left) > A.get(right)) largest = right;

        if(largest != i) {
            swap(i,largest);
            heapify_down(largest);
        }
    }

    public void add(Integer key) {
        A.addElement(key);//add the key in the vector
        int index = size() - 1;//give it the last index
        heapify_up(index);//heapify it towards the top to make a valid heap
    }

    public Integer peek(){
        try {
            if(size() == 0) throw new Exception("Index out of range (Heap Underflow)");
            return A.firstElement();
        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    public Integer poll() {
        try{
            if(size() == 0) throw new Exception("Index out of range (Heap Underflow)");
            int root = A.firstElement();//save the root
            A.setElementAt(A.lastElement(),0);//put the last element at the root
            A.remove(size()-1);//remove the empty space
            heapify_down(0);//heapify towards the bottom and make it a valid heap
            return root;
        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public void clear() {
        while (!A.isEmpty()) System.out.println(poll() + " ");
    }
}
