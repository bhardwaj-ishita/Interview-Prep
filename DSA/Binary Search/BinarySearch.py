#Iterative
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        
        i,j = 0, len(nums) - 1
        return self.solve(nums, i, j, target)
        
            
            
    def solve(self, nums, i, j, target):
        if i>j:
            return -1 
        m = (i + j)//2
        
        if nums[m] == target:
            return m
        elif nums[m] > target:
            return self.solve(nums, i, m-1, target)
        else:
            return self.solve(nums, m+1, j, target)
