package com.company;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    public static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // add your code here
        boolean[] visited = new boolean[V];

        for(boolean i : visited) i = false;

        Stack<Integer> stack = new Stack<Integer>();

        for(int i = 0 ; i < V; i++) {
            if(!visited[i]) DFS(0,adj,stack,visited);
        }

        int[] ans =new int[stack.size()];
        int i = 0;

        while(!stack.isEmpty()) ans[i++] = stack.pop();
        return ans;
    }

    public static void DFS(int v, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack, boolean[] visited) {
        visited[v] = true;
        for(int u : adj.get(v)) {
            if(!visited[u]) DFS(u,adj,stack,visited);
        }
        stack.push(v);
    }
}
