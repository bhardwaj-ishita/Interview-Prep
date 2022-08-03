#A few test cases are not getting solved :/

class Solution:
    def safePos(self, n, k):
        # code here 
        person = []
        for i in range(1,n+1):
            person.append(i)
        return self.sol(person,0,k-1)
    
    def sol(self,person,i,k):
        if len(person) == 1:
            return person[0]
        
        
        i = (i+k)%len(person)
        person.pop(i)
        return self.sol(person,i,k)
