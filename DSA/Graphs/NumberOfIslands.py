'''
The only thing to remember is that, here instead of using a visited array, I turned all 1s to -1 to mark visited

And, we not only go down and right, but there are situations where you'll have to go up and left too. So DFS in all four directions
'''
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        #n^2 traversal
        count = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == "1":
                    count += 1
                    self.dfs(i,j,grid)
        return count
                    
        
    def dfs(self, i, j, grid):
        #dfs for each unvisited 1
        #one dfs shows 1 island
        if 0 <= i < len(grid) and 0 <= j < len(grid[0]) and grid[i][j] == "1":
            grid[i][j] = -1
            self.dfs(i,j+1,grid)
            self.dfs(i+1,j,grid)
            self.dfs(i,j-1,grid)
            self.dfs(i-1,j,grid)
            return 
