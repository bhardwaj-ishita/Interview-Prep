class Solution:
    def nextLargerElement(self,arr,n):
        #code here
        ans = [0 for i in range(n)]
        stk = []
        
        for i in range(n-1, -1, -1):
            curr = arr[i]
            if len(stk) != 0:
                while len(stk) != 0 and stk[-1] < curr:
                    stk.pop()
            if len(stk) == 0:
                ans[i] = -1
            elif stk[-1] > curr:
                ans[i] = stk[-1]
            
            stk.append(curr)
            
        return ans

#NextGreaterII
class Solution:
    def nextGreaterElements(self, arr: List[int]) -> List[int]:
        stk = []
        #assume that none of the elements have a NGE(Next Greater Element)
        ans = [-1 for i in range(len(arr))]
        
        #we run the algorithm twice
        #once for getting NGE for all the elements that we are getting without the circulart integer array
        #second time we have a stack full of NNGE elements and now we check for all elemnts that have -1 (because assuming these elements are the greatest)
        
        for j in range(2):
            for i in range(len(arr)-1, -1,-1):
                curr = arr[i]
                while stk and stk[-1] <= curr:
                        stk.pop()
                if stk:
                    ans[i] = stk[-1]

                stk.append(curr)
                
        return ans
