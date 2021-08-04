package com.company;

import java.util.ArrayList;

public class PrintAdjList {
    /**
     * O(V+E) Time complexity
     * @param V
     * @param adj
     * @return
     */
    public ArrayList<ArrayList<Integer>> printGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            ans.add(new ArrayList<Integer>());
            ans.get(i).add(i);
            for(int u: adj.get(i)) {
                ans.get(i).add(u);
            }
        }
        return ans;
    }
}
