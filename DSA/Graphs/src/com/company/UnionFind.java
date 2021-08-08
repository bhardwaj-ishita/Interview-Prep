package com.company;

public class UnionFind {
    public int count = 0;
    public int[] id = null;

    public UnionFind(int m, int n, char[][] grid) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '1') count++;
            }
        }
        id = new int[m*n];

        //here we are assiging evey node as it's own parent or you can assign -1 as it's parent
        for(int i = 0; i < m * n; i++) id[i] = i;
    }

    public int find(int index) {
        int parent = id[index];
        while(index != parent) {//jab tak we don't find an index which is it's own parent
            index = parent;//now we'll make the parent the node
            parent = id[parent];//and make the id[parent] as the new parent
        }
        return index;
    }

    public void union(int p, int q) {
        int parentP = find(p);
        int parentQ = find(q);
        if(parentP == parentQ) return;
        id[parentP] = parentQ;
    }

    public boolean isConnected(int p, int q) {
        int parentP = find(p);
        int parentQ = find(q);
        if(parentP != parentP) return false;
        else return true;
    }

}
