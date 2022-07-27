class Solution:
    #Function to find the height of a binary tree.
    def height(self, root):
        # code here
        if root is None:
            return 0
        
        count = max(self.height(root.left),self.height(root.right))
        
        return count + 1
