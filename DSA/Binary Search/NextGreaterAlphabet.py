import sys
class Solution:
    def nextGreatestLetter(self, a: List[str], target: str) -> str:
        n = len(a)
        if a[0] > target or a[n-1] <= target:
            return a[0]
        i = 0
        j = n - 1
        while i <= j:
            m = i + ((j-i)//2)
            if a[m]> target:
                j = m - 1
            elif a[m] <= target:
                i = m + 1
        
        return a[i]
