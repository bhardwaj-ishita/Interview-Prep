class Solution:
    def numSquares(self, n: int) -> int:
        
        #for values 0 and 1
        if n < 2:
            return n
        
        #to store the req squares
        squares = []
        i = 1
        while i*i <= n:
            squares.append(i*i)
            i+=1
           
        
        #creation of the tree
        check = {n}
        count = 0
        while check:
            count += 1
            temp = set()
            for x in check:
                for y in squares:
                    if x == y:
                        return count
                    if x < y:
                        break
                    temp.add(x-y)
            
            check = temp
        
        return count
