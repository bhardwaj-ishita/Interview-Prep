class Solution:
    
    #Function to delete middle element of a stack.
    def deleteMid(self, s, sizeOfStack):
        # code here
        self.recur(s,len(s)//2)
        
    def recur(self,s,count):
        if count == 0:
            s.pop()
            return
        
        temp = s.pop()
        self.recur(s,count-1)
        s.append(temp)
        return
