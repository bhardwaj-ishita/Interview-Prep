package com.company;

import java.util.ArrayList;

public class DFS {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] visited = new boolean[V];
        ArrayList<Integer> list = new ArrayList<>();
        return DFS(0,adj, visited, list);

    }

    public ArrayList<Integer> DFS(int v, ArrayList<ArrayList<Integer>> adj,boolean[] visited, ArrayList<Integer> list)
    {
        visited[v] = true;
        list.add(v);
        for(int u: adj.get(v)){
            if(!visited[u]) {
                DFS(u,adj,visited,list);
            }
        }
        return list;
    }
}
