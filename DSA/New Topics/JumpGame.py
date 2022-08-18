#O(n^2) time complexity

class Solution:
    def jump(self, nums: List[int]) -> int:
        '''
        So this is a normal question which can also be solved with dp
        Brute force is to use two loops
        1 loop to iterate from 0 to n-1
        and at each step, loop 2: find the jump which will land us on a step with max jumps available
        
        Now here there are some problems which might be repeating, so we can create an extra space to
        reduce the repeating cases
        
        some info we'll need to guess a solution is, how many jumps are being used.
        So we can't start from 0 to n-1 because then we don't know how many jumps were actually there
        
        Instead we start from n-1 to 0, at every ith index we have the min no. of jumps required to
        reach from i to n-1, and min (index value from i+1 to n-1) + 1 is the value of the ith index
        '''
        if len(nums) == 0:
            return 0
        jumps = [0]*len(nums)
        
        for i in range(len(nums)-2,-1,-1):
            minJumps = float('inf')
            j = i + 1
            while j <= i+nums[i] and j < len(nums):
                minJumps = min(minJumps,jumps[j])
                j+=1
            
            jumps[i] = minJumps+1
        
        print(jumps)
        return jumps[0]
      
      
      
