class Solution:
    # your task is to complete this function
    # function sort the stack such that top element is max
    # funciton should return nothing
    # s is a stack
    def sorted(self, s):
        # Code here
        if len(s) == 0:
            return s
        
        temp = s.pop()
        self.sorted(s)
        self.insert(s,temp)
        return s
    
    def insert(self, s, temp):
        if len(s) == 0 or temp >= s[-1]:
            s.append(temp)
            return
        
        val = s.pop()
        self.insert(s,temp)
        s.append(val)
        return
