package com.company.PriorityQueue;

import com.company.Heap;

public class MinHeap extends Heap {
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
}
