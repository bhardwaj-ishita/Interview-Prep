'''
So this question tells you to stop overthinking
This is a recursive problem

By using IBH method, you only think what will happen in the next step when you N-1 
And not all the way to N-2 and N-3 and so on

Think the base condition if there is only 1 disc, you put it directly to the destination

Hypothesis
If you have N discs, you first sort the N-1 discs. That is deal with the smaller input
The smaller input being, if you have N-1 discs, put them from source to helper first
And put Nth disc at destination

Induction
Now at this point N-1 discs are at aux. And nth disc is at dest.
We need to put back the N-1 discs back at top of Nth disc at dest

So we do that. Put N-1 back to destination
'''
class Solution:
    def toh(self, N, fromm, to, aux):
        # Your code here
        #put final disc from 1 to 3 direct
        if N == 1:
            print("move disk " + str(N) + " from rod " + str(fromm) + " to rod " + str(to))
            return 1
        
        #puts all n-1 discs from 1 to 2
        count = self.toh(N-1, fromm, aux, to) 
        
        #put Nth disc from 1 to 3
        print("move disk " + str(N) + " from rod " + str(fromm) + " to rod " + str(to))
        
        #when all n-1 discs are at 2, and nth disc at 3, put all n-1 back from 2 to 3
        count += self.toh(N-1, aux, to, fromm)
        
        return count + 1
      
      
#OUTPUT
'''
INPUT: 2 discs

move disk 1 from rod 1 to rod 2
move disk 2 from rod 1 to rod 3
move disk 1 from rod 2 to rod 3
3 

#this is the number of moves

'''
