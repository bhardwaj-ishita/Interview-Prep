package com.company.WordProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TreeMatching {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while(st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch(IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) {
        FastReader fs = new FastReader();
        int n = fs.nextInt();
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n-1; i++) {
            edges.add(new ArrayList<>());
            edges.add(new ArrayList<>());
            edges.get(i).add(fs.nextInt());
            edges.get(i).add(fs.nextInt());
            adj.add(new ArrayList<>());
        }
        adj.add(new ArrayList<>());

        for(int i = 0; i< n-1; i++) {
            adj.get(edges.get(i).get(0)-1).add(edges.get(i).get(1)-1);
        }
        DFS(adj,0);
        System.out.println(ans);
    }

    public static int ans= 0;
    public static int DFS(ArrayList<ArrayList<Integer>> adj, int v) {
        int val = 0;
        boolean status = true;
        for(int u: adj.get(v)) {
            status = false;
            val += DFS(adj,u);
            if(val >= 1) return ans;
        }
        if(status) ans++;
        return ans;
    }
}
/*
5
1 2
1 3
3 4
3 5
 */