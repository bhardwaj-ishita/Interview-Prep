package com.company.PriorityQueue;

public class MinPriorityQueue extends MinHeap {

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
