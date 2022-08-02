'''
We take 3 values side by side, 
string, start and end

in the recursive tree,
when we have equal number of start and end i.e. start == end
    we only add a start bracket because there is nothing to close
when we have no start i.e. start == 0
    we only add end bracket because there is nothing to start
else
    keep making decisions of adding start or end
    
and the moment both hit ZERO
    append the answer and return
'''
class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        ans = []
        return self.sol("",n,n,ans)
    
    def sol(self, s, start, end, ans):
        if start == 0 and start == end :
            ans.append(s)
            return ans
        
        if start == end:
            self.sol(s+"(",start-1,end,ans)
        elif start == 0:
            self.sol(s+")",start,end-1,ans)
        else:
                self.sol(s+"(",start-1,end,ans)
                self.sol(s+")",start,end-1,ans)
        
        return ans
