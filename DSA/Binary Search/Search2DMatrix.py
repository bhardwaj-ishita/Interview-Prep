class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        #m = len(matrix) == column = j
        #n = len(matrix[0]) == row = i
        #matrix[j][i] ---> j ++ and i--
        #Time complexity = O(m+n) from O(n^2)
        
        m = len(matrix)
        n = len(matrix[0])
        i = n - 1
        j = 0
        
        while 0 <= i < n and 0 <= j < m:   
            if matrix[j][i] == target:
                return True
            elif matrix[j][i] > target:
                i = i - 1
            elif matrix[j][i] < target:
                j = j + 1
        
        return False
      
      
      
