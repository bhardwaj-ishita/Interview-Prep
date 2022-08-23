'''
Irritating question to be honest

They are calling for the diameter, in terms of, not the height, but the edges in between

So we check the temp to be sent to the ancestor
temp = 1 + max(l,r)

and we store the current node's result for future purspose, when we'll need to compare if the diameter is going through the senior or the junior
res = max(l+r,res)

if we were to count the height in terms of nodes, then 
res = max(1+l+r,res)

and return the temp for the senior to calculate their answer too
return temp
'''

class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        
        def solve(root):
            nonlocal res
            #Base
            if not root:
                return 0

            #Hypothesis
            l = solve(root.left)
            r = solve(root.right)

            #Induction
            temp = 1+max(l,r)
            res = max(l+r,res)
            return temp
        
        res = 0
        solve(root)
        return res
