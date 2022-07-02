class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        stack = [-1]
        right = [len(heights) for i in range(len(heights))]
        left = [-1 for i in range(len(heights))]
        
        for i in range(len(heights)-1,-1,-1):
            while stack and heights[stack[-1]] >= heights[i]:
                stack.pop()
            if stack:
                right[i] = stack[-1]
                
            stack.append(i)
            
            
        #on the left side    
        stk = [-1]
        for i in range(len(heights)):
            while stk and heights[stk[-1]] >= heights[i]:
                stk.pop()
            if stk:
                left[i] = stk[-1]
    
            stk.append(i)
            
        
        maxArea = 0
        for i,height in enumerate(heights):
            width = (right[i] - (left[i])) - 1
            area = width*height
            maxArea = max(maxArea, area)
            
        return maxArea
      
'''
**Brute force:**
I take every element and find the maximum area it can cover with that height
For example: (2,1,5,6,2,3)

let i = 0 --> 2
here we'll take height = 2
and we'll have to find the width
but the maximum width it can cover with height = 2 is 1
area = 2*1
hence maxArea = 2*1

let i = 1 --> 1
height = 1
maxWidth = 6 (from i = 0 to i = 5)
area = 1*6
hence maxArea = 1*6

let i = 2 --> 5
height = 5
maxWidth = 2 (from i = 2 to i = 3)
area = 5*2
maxArea  = 5*2

and so on....

But this approach will take one loop to iterate over the list to find the height
another loop to find the maxWidth

Hence it is a O(n^2) time complexity algortithm
And we can definitely do better.

**Optimized Approach:**
We'll find the right boundry till we can expand and the left boundry till we can expand to find the maxArea.
And we'll find it by using the algorithm of the next smaller element in the array. 
height = current index
left boundry = the next smallest element index to left
right boundry = the next smallest element index to the right
width = right boundry - left boundry - 1
area = width * height

for elements that don't have a next smallest integer
for them, put right[i] = len(heights)
for them, put left[i] = -1


As for next smallest integer, remember:
append adds the value in by increasing the length
So if you're putting default values in, then use right[i]  = value
else in the for loop itself keep appending -1 or heights side by side 
'''
