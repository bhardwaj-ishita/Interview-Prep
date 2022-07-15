class Solution:
        def searchRange(self, a: List[int], k: int) -> List[int]:
      
            def solve_left():
                start = 0
                end = len(a) - 1
                ans = -1
                while start <= end:
                    mid = (start + end)//2
                    if a[mid] == k:
                        ans = mid
                        end = mid - 1
                    elif a[mid] > k:
                        end = mid - 1
                    else:
                        start = mid + 1
                return ans
            
            def solve_right():
                start = 0
                end = len(a) - 1
                ans = -1
                while start <= end:
                    mid = (start + end)//2
                    if a[mid] == k:
                        ans = mid
                        start = mid + 1
                    elif a[mid] > k:
                        end = mid - 1
                    else:
                        start = mid + 1
                return ans
                
            first = solve_left()
            last = solve_right()
            return first,last  
                    
