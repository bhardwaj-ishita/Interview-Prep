'''
Here the proble is the -ve values in the code

temp store the value to be given to the senior
  either max(l,r) + root.val
  or root.val #if the incoming values from l and r are comming negetive, then we can discard that whole line and send the val of root itself
 
ans stores the value comparison if the value sent to senior is max or the calculation for path sum is max through the given node itself
 ans = max(temp,l+r+root.val)
 
res stores the max answer of all nodes' max answer
  res = max(ans,res) i.e. max of senior answer and current node's answer
  
 
'''


import sys
class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        
        def solve(root):
            nonlocal res
            
            if not root:
                return -1*sys.maxsize
            
            l = solve(root.left)
            r = solve(root.right)
            
            
            temp = max(max(l,r)+root.val, root.val)
            ans = max(temp, l+r+root.val)
            res = max(res,ans)
            
            return temp
        
        res = -1*sys.maxsize
        solve(root)
        return res
