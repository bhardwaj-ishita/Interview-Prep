class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        
        self.dfs(sr,sc,image,color,image[sr][sc])
        return image
        
    def dfs(self, i, j, image, color, current):
        if 0 <= i < len(image) and 0 <= j < len(image[0]) and image[i][j] == current and image[i][j] != color:
            image[i][j] = color
            self.dfs(i,j+1,image,color,current)
            self.dfs(i+1,j,image,color,current)
            self.dfs(i,j-1,image,color,current)
            self.dfs(i-1,j,image,color,current)
