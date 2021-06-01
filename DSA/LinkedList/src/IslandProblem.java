import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <h1>Max Area of Island</h1>
 * https://leetcode.com/problems/max-area-of-island/solution/
 *
 * It was a Daily Leetcode Challenge. Not a linked list question may I just put it out there.
 *
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
 * You may assume all four edges of the grid are surrounded by water.
 *
 * The area of an island is the number of cells with a value 1 in the island.
 *
 * Return the maximum area of an island in grid. If there is no island, return 0.
 *
 * @author Ishita Bhardwaj
 * @version 11.01
 * @since   2021-06-01
 * */

public class IslandProblem {

    //User Defined Fastreader class
    static class Fastreader {
        BufferedReader br;
        StringTokenizer st;

        public Fastreader() {
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        float nextFloat() {
            return Float.parseFloat(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }


    public static int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        int maxAns = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    ans = checkTheEdges(grid, i, j);
                    maxAns = Math.max(ans, maxAns);
                    System.out.println("max: " + maxAns);
                }
            }
        }
        return maxAns;
    }

    public static int checkTheEdges(int[][] grid, int i, int j) {
        if(i >= grid.length || j >= grid[0].length) return 1;
        grid[i][j]  = -1;
        int answer = 0;
        if(i < grid.length -1 && grid[i+1][j] == 1) {
            answer = answer + checkTheEdges(grid, i+1, j);
            System.out.println("down: " + answer);
        }
        if(j < grid[0].length -1 && grid[i][j+1] == 1 ) {
            answer = answer + checkTheEdges(grid, i, j+1);
            System.out.println("right: " + answer);
        }
        if(i >= 1 && grid[i-1][j] == 1) {
            answer = answer + checkTheEdges(grid, i-1, j);
            System.out.println("up: " + answer);
        }
        if(j >= 1 && grid[i][j-1] == 1) {
            answer = answer + checkTheEdges(grid, i, j-1);
            System.out.println("left: " + answer);
        }

        return answer + 1;
    }

    public static void main(String[] args) {
        Fastreader fs = new Fastreader();
        int[][] grid = new int[8][13];
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j <  13; j++) {
                grid[i][j] = fs.nextInt();
            }
        }
        System.out.println(maxAreaOfIsland(grid));

    }
}

/*
INPUT:
0 0 1 0 0 0 0 1 0 0 0 0 0
0 0 0 0 0 0 0 1 1 1 0 0 0
0 1 1 0 1 0 0 0 0 0 0 0 0
0 1 0 0 1 1 0 0 1 0 1 0 0
0 1 0 0 1 1 0 0 1 1 1 0 0
0 0 0 0 0 0 0 0 0 0 1 0 0
0 0 0 0 0 0 0 1 1 1 0 0 0
0 0 0 0 0 0 0 1 1 0 0 0 0

OUTPUT: 6
 */
