package com.company;

public class NumberOfIslands {

    /**
     * Basic DFS used. As you find the starting of the island i.e the first '1'
     * start searching in all the four directions and drown them i.e make them 0
     * and move forward and keep counting the number of times you found the first '1'
     * the count tells the number of island
     *
     * visit the  cells at least once but can go to some cells more than once
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    DFS(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void DFS(char[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j]!='1') return;
        grid[i][j] = 0;
        DFS(grid, i-1, j);
        DFS(grid, i, j-1);
        DFS(grid, i+1, j);
        DFS(grid, i, j+1);
    }

    //OPTIMIZATION (max visit all cells once)
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int result = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1)  {
                    result += 4;
                    if(i > 0 && grid[i-1][j] == 1) result -= 2;
                    if(j > 0 && grid[i][j-1] == 1) result -= 2;
                }
            }
        }

        return result;
    }
}
