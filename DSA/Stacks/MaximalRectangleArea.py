class Solution:
    
    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        
        arr = [0 for i in range(len(matrix[0]))]
        maxArea = 0
        
        for i in range(len(matrix)):
            for j in range(len(matrix[i])):
                matrix[i][j] = int(matrix[i][j])
                if matrix[i][j] is 0:
                    arr[j] = 0
                elif matrix[i][j] is 1:
                    arr[j] = arr[j] + 1
            area = self.MAH(arr)
            maxArea = max(area, maxArea)
            
        return maxArea
        
    
    
    def MAH(self, arr):
        
        #NSL
        left = [-1 for i in range(len(arr))]
        stack1 = []
        
        for i in range(len(arr)):
            while stack1 and arr[stack1[-1]] >= arr[i]:
                stack1.pop()
            if stack1:
                left[i] = stack1[-1]
            stack1.append(i)
            
        #NSR
        right = [len(arr) for i in range(len(arr))]
        stack2 = []
        for i in range(len(arr)-1,-1,-1):
            while stack2 and arr[stack2[-1]] >= arr[i]:
                stack2.pop()
            if stack2:
                right[i] = stack2[-1]
            stack2.append(i)
        
        #maxArea
        maxArea = 0
        for i,height in enumerate(arr):
            width = (right[i] - left[i]) - 1
            area = width*height
            maxArea = max(area,maxArea)
        
        return maxArea
    
    
# a few things to remember
# take care to convert strings to int
# be carefull while writing the code for NSR, NSL or NLR, NLL
# they get a bit confusing

# we know max area of histogram which is for a 1d array
# max area for binary matrix is similar but just for a 2d array
# so we'll find max area for each row and find the max out of it
