'''
    Here the few test cases to keep in mind are:
    1. all digits: return in the starting itself
    2. all alphabets: 
    3. mix
    
    2/3 can be tackled by recursion. If we get s[n] as a digit, then don't do anything, just send back
    If s[n] is an alphabet, then swap the case(not necessary that it will always be lower) and modify the string and backtrack
    
    Few new functions are
    swapcase() : swaps case from lowert to upper or upper to lower
    isdigit() : if all string contains numbers --> bool
    isalpha() : if all string contains alphabets -- bool
    '''

class Solution:
    def letterCasePermutation(self, s: str) -> List[str]:
        n = len(s)
        ans = []
        if s.isdigit():
            return [s]
        self.sol(s,len(s)-1,ans)
        return ans
        
    def sol(self, s, n, ans):
        if n < 0:
            ans.append(s)
            return ans
        
        if s[n].isalpha():
            self.sol(s,n-1,ans)
            s = s[:n] + s[n].swapcase() + s[n+1:]
            self.sol(s,n-1,ans)
        else:
            self.sol(s,n-1,ans)
        
        return ans
        
