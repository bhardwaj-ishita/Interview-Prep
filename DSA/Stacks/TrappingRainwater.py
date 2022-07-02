class Solution:
    def trap(self, height: List[int]) -> int:
        
        #so apparently the concept of NGL or NGR won't be used here.
        # what we see here is how much water is above the ith building
        maxr = self.right(height)
        maxl = self.left(height)
        water = 0
        for i in range(len(height)):
            water = water + min(maxr[i],maxl[i]) - height[i]
        return water
    
    # max boundary towards right to make a container
    def right(self, height):
        right = [0 for i in range(len(height))]
        maxr = 0
        for i in range(len(height)-1,-1,-1):
            maxr = max(maxr,height[i])
            right[i]  = maxr
            
            
        return right
     
    # max boundry towards left to make a continer
    def left(self, height):
        left = [0 for i in range(len(height))]
        maxl = 0
        for i in range(len(height)):
            maxl = max(maxl,height[i])
            left[i] = maxl
        
        return left
