#Count of Subsets in given array who have average equal to K

#This method is not optimal I think. Still have to confirm. 
#It is n^2, as we are iterating the whole map again and again for each jth index

class Solution:
    def lenOfLongSubarr (self, a, k) : 
        #Complete the function
        j = 0
        ans = 0
        sums = 0  
        
        m = dict()
        
        while j < n:
            sums += a[j]
            
            if sums/(j+1) == k:
                ans += 1
            else:
              for i in m.keys():
                if ((sums - i)/(j - m[i])) == k:
                  ans += 1
                
            if sums not in m:
                m[sums] = j
            j+=1
        
        return ans
