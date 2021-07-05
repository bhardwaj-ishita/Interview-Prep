package com.company;

import java.util.Vector;

//difference between arrayList and Vector
//https://stackoverflow.com/questions/2986296/what-are-the-differences-between-arraylist-and-vector

public class Heap {

    public Vector<Integer> A;

    public Heap() {
        A = new Vector<>();
    }

    public Heap(int capacity) {
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
}
