'''
Here if the starting bracket comes, append
else pop
and after popping if stack is empty that is till now there is no valid string, so add the current index and move the search forward
else if the stack is not empty, maximize the ans out of length or current i - stack.peek()
'''

class Solution:
    def longestValidParentheses(self, s: str) -> int:
        stack = [-1]
        length = 0
        i = 0
        while i < len(s):
            if s[i] == '(':
                stack.append(i)    
            else:
                stack.pop()
                if not stack:
                    stack.append(i)
                else:
                    length = max(length,i-stack[-1])
            i+=1
        
        return length
      
      
#for () , {}, []
#valid parentheses


class Solution:
    def longestValidParentheses(self, s: str) -> int:
        stack = [-1]
        length = 0
        i = 0
        while i < len(s):
            if s[i] in {'{','(','['}:
                stack.append([s[i],i])    
            else:
                stack.pop()
                if not stack:
                    stack.append(i)
                else:
                    length = max(length,i-stack[-1])
            i+=1
        
        return length
