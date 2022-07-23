#When the all values in the array are positive
'''
IF the sum is < k: keep addin the a[j]th value
If the sum is == k: save the max ans and move forward
If the sum is > k: keep removing the ith value till the sum is either = or < k
'''
class Solution:
    def lenOfLongSubarr (self, a, n, k) : 
        #Complete the function
        i, j = 0,0
        ans = 0
        sums = 0  
        
        while j < n:
            sums += a[j]
            if sums == k:
                ans = max(ans, j - i + 1)
            elif sums > k:
                while sums > k:
                    sums -= a[i]
                    i += 1
            j+=1
        return ans
                
        
#When the values in the array can be negetive too
'''
This question gets tricky as we add some negetive elements in the array
In the basic question we only have positive values, so it was common sense that as we go forward we will definitely be increasing the value of the sums
and if we increment i variable we will be deducting the value of sums

But here, due to the presence of -ve values, incrementing j doesn't gaurentee that the sums will increase and same for i, it doesn't gaurantee that removing it from 
the sums the value will be decreasing.

So what we do is we will keep addin the sum and in most cases it'll keep on going up or down.
At any point if we found a value in the totals sums at every index that when removed from the current sum gives k, we will save the length (j - map[sums - k])
in the ans. And keep doing that till we reach the end and find a max
                                                      0 1 2 3 4 5 6 7 8 9 10 11
We will save the total sum at every index in the map. --------------__________  
Let the dotted line be the sum of values till i(=7) index from 0
Let the continuous line be the sum of values till the jth(=11)index form 0
Now when the dotted line sum is removed from the continuous line sum we get K
'''
class Solution:
    def lenOfLongSubarr (self, a, n, k) : 
        #Complete the function
        j = 0
        ans = 0
        sums = 0  
        
        m = dict()
        
        while j < n:
            sums += a[j]
            
            if sums == k:
                ans = max(ans,j + 1)
            elif (sums - k) in m:
                ans = max(ans,j - m[sums-k])
                
            if sums not in m:
                m[sums] = j
            j+=1
        
        return ans
