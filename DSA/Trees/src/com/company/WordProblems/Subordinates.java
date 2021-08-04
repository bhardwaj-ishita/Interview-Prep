package com.company.WordProblems;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Subordinates {
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

    public static void main(String[] args) throws IOException {
        FastReader fs= new FastReader();
        int n = fs.nextInt();
        int[] a = new int[n-1];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(n);
        int[] subordinates = new int[n];

        //long start = System.currentTimeMillis();
        for(int i = 0; i < n-1; i++) {
            a[i] = fs.nextInt();
            adj.add(i,new ArrayList<>());
            subordinates[i] = -1;
        }

        adj.add(n-1,new ArrayList<>());
        subordinates[n-1] = -1;

        for(int i = 0; i < n-1; i++) {
            adj.get(a[i]-1).add(i+1);
        }

        DFS(subordinates,adj,0);

        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i: subordinates) output.write(i + " ");

        output.flush();
        //long end = System.currentTimeMillis();
        //System.out.println(end-start);

    }

    public static int DFS(int[] subordinates, ArrayList<ArrayList<Integer>> adj, int v) {
        int count = 0;
        for(int u: adj.get(v)) {
            if(subordinates[u] == -1) {
                count += DFS(subordinates,adj,u) + 1;
            }
            else if(subordinates[u]!=-1) {
                count += subordinates[u] + 1;
            }
        }
        subordinates[v] = count;
        return count;
    }
}
