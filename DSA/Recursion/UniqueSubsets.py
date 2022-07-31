#Function to find all possible unique subsets.
#Print them in lexicographical order
#All the subsets should also be in sorted order

class Solution:
    def AllSubsets(self, arr,n):
      
        #I sorted the array before hand, because i needed the subsets themselves in a sorted order eg. 2,1,2 --> 1,2,2
        arr.sort() 
        
        #called the main recursive function
        ans = self.sol(arr,n,[],"")
        
        #I used the map to remove any duplicate subsets
        map = {}
        for  i in ans:
            if i not in map:
                map[i] = 1
            else:
                map[i] += 1
        
        #after removind duplicate keys, append them in a list res and sort it and return
        res = []
        for i in map.keys():
            res.append(i)
            
        res.sort()
        return res
        
    def sol(self,a,n,ans,subset):
        if n == 0:
            ans.append(subset)
            return ans
        
        self.sol(a,n-1,ans,subset)    
        subset = str(a[n-1]) + subset
        self.sol(a,n-1,ans,subset)
        
        return ans
