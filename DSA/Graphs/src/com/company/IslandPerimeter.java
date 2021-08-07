package com.company;

public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        if(grid == null) return 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) return DFS(grid, i, j);
            }
        }

        return 0;
    }

    public int DFS(int[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[i].length) return 1;
        if(grid[i][j] == 0) return 1;
        if(grid[i][j] == -1) return 0;

        int count = 0;
        grid[i][j] = -1;

        count += DFS(grid, i - 1, j);
        count += DFS(grid, i, j - 1);
        count += DFS(grid, i + 1, j);
        count += DFS(grid, i, j + 1);

        return count;
    }
}
