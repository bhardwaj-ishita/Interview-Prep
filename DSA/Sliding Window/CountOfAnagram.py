class Solution:

	
	def search(self,pat, txt):
        #we get the basics
        n = len(txt)
        i,j = 0,0
        k = len(pat)
        ans = 0
        
        #map created to store occurrences of each character
        map = {}
        for x in pat:
            if x in map:
                map[x] += 1
            else:
                map[x] = 1
        
        #instead of accessing the map at every point, count can be used to monitor if all the chars are present in the window by incrementing/decrementing
        count = len(map)
        
        while j < n:
            #calculation
            #if the char is in pat, then decrement the count of it
            #and if the count of it is equal to the amount required i.e. ==0 then count--
            if txt[j] in map:
                map[txt[j]] -= 1
                if map[txt[j]] == 0:
                    count -= 1
                
            if (j - i + 1) == k:
                #ans calculation
                if count == 0:
                    ans += 1
                
                #if the ith index is in pat then increase it's required count and if it is 1 then count++
                if txt[i] in map:
                    map[txt[i]] += 1
                    if map[txt[i]] == 1:
                        count += 1
                
                i += 1
            j += 1
            
        return ans
