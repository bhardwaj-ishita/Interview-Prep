package com.company;

import java.util.ArrayList;

public class SourceToDestination {

    public int possible_paths(int[][] edges, int n, int s, int d)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
        }

        if(s==d) ans = 1;
        DFS(adj,s,d);

        return ans;
    }

    public int ans = 0;

    public void DFS(ArrayList<ArrayList<Integer>> adj, int s, int d) {
        for(int u: adj.get(s)) {
            if(u==d) ans++;
            DFS(adj,u,d);
        }
        return;
    }
}
