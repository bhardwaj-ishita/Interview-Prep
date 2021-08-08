package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * one of the ways to detect cycle in an directed graph is by using topological sort
 * We can assume from the starting that the graph is DAG
 * and if we are not able to form the TS of the graph then it has a cycle
 *
 * Our main focus is to keep checking if the parent of a child is the child's child too somewher
 * if yes then it's a cycle
 *
 * And unlike undirected graph where we only need to check the root parent
 * here we keep the nodes(parents) in a hierarchy as we always have to keep looking for the immediate parent
 */
public class detectCycleDirected {
    public boolean canFinish(int n, int[][] pre) {
        boolean[] visited = new boolean[n];
        for(boolean i : visited) i = false;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<Integer>());
        for(int i = 0; i < pre.length; i++) adj.get(pre[i][1]).add(pre[i][0]);
        //for(int i : adj.get(18)) System.out.println(i);


        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++) {
            if(!visited[i]) DFS(i, adj,stack, visited);
        }
        // System.out.println(stack);
        //  for(int i = 0; i < n; i++) {
        //      System.out.print(i +": ");
        //      for(int u: adj.get(i)) {
        //          System.out.print(u + " ");
        //      }
        //      System.out.println();
        //  }
        int ind = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(!stack.isEmpty()) {
            //System.out.println(stack.peek());
            map.put(stack.pop(),ind);
            ind++;
        }

        for(int i = 0; i < n; i++) {
            for(int u: adj.get(i)) {
                //System.out.println(i + ": " + u);
                if(map.get(i) >= map.get(u)) return false;
            }
        }
        return true;

    }

    public void DFS(int v ,ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack, boolean[] visited) {
        visited[v] = true;
        for(int u : adj.get(v)) {
            if(!visited[u]) DFS(u,adj,stack,visited);
        }
        stack.push(v);

    }

}
