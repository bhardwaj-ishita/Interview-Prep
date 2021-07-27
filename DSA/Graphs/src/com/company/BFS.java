package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public ArrayList<Integer> BFS(int V, ArrayList<ArrayList<Integer>> adj)
    {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[V];
        int n = 0;
        visited[n] = true;
        queue.add(n);
        while(!queue.isEmpty()) {
            int value = queue.poll();
            list.add(value);
            for(int i: adj.get(value)) {
                if(!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        return list;

    }
}
