'''
So twist in the game
This question is not actually about the recursion
But the Original and Complement of the value. It's Logic and Maths.

We don't need to build the whole string per say
But we map it to the basic unit of the string i.e. 0 to find the answer out of this 0 itself

So the answer is dependent on how many NOTs are added above the 0 at index 0

For example NOT(NOT(0)) is the answer for n = 4, k = 6

0
0 | 1
01 | 10
0110 | 1001

Here if you observe the string is same as the n-1th string till mid of nth string 
And the second half of nth string is the complement of n-1th string
nth string = n-1th string + NOT(n-1th string)

So if k lies above the mid, we take a NOT
Else take the number itself.

And int(boolean) turns true and false to 1 and 0

'''


class Solution:
    def kthGrammar(self, n: int, k: int) -> int:
        if n== 1:
            return 0
        
        mid = pow(2,n-1)//2
        if k <= mid:
            return int(self.kthGrammar(n-1,k))
        else:
            return int(not self.kthGrammar(n-1,k-mid))
        
