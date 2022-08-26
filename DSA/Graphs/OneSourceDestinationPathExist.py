class Solution:
    
    #Function to find whether a path exists from the source to destination.
	def is_Possible(self, grid):
	    #Code here
		
		n = len(grid)
		m = len(grid[0])
		source = []
		for i in range(len(grid)):
		    for j in range(len(grid[0])):
		        if grid[i][j] == 1:
		            source.append(i)
		            source.append(j)
		            break
		
		if self.dfs(source[0],source[1],grid):
		    return True
		return False
	
	def check(self, i, j ,grid):
	    if 0 <= i < len(grid) and 0 <= j < len(grid[0]):
	        return True
	    return False
		
	def dfs(self,i,j,grid):
	    if self.check(i,j,grid) and grid[i][j] != -1 and grid[i][j] != 0:
	        if grid[i][j] == 2:
	            return True
	        
            grid[i][j] = -1
            if self.dfs(i+1,j,grid):
                return True
            if self.dfs(i,j+1,grid):
                return True
            if self.dfs(i-1,j,grid):
                return True
            if self.dfs(i,j-1,grid):
                return True
        
        return False
