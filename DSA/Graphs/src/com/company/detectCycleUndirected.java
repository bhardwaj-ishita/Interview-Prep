package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * only concern we have in undirected graph is that besides it's immediate parent if it is connected with
 * a vertex which is already visited then it is in a cycle
 */
public class detectCycleUndirected {

    public boolean byDFS(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                if(DFS(i,adj,visited, -1)) return true;
            }
        }
        return false;
    }

    public boolean DFS(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int parent)
    {
        visited[v] = true;
        for(int u: adj.get(v)) {
            if(!visited[u]) {
                if(DFS(u,adj,visited, v)) return true;

            }
            else if(visited[u] && u != parent) return true;
        }
        return false;
    }
}
