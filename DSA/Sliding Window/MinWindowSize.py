class Solution:
    def minWindow(self, s: str, t: str) -> str:
        n = len(s)
        i,j = 0,0
        
        store = {}
        for x in t:
            if x in store:
                store[x] += 1
            else:
                store[x] = 1
        count = len(store)
        
        ans = ""
        
        while j < n:
            
            #keep incrementing j and decrementing map and count values
            if s[j] in store:
                store[s[j]] -= 1
                if store[s[j]] == 0:
                    count -= 1
            
            #if all desired values in the window
            if count == 0:
                
                #save the ans
                window = j-i+1
                if not ans or window < len(ans):
                    ans = s[i:j+1]
                
                #increment i while we still have desired count
                while count == 0:
                    if s[i] in store:
                        store[s[i]] += 1
                        if store[s[i]] == 1:
                            count += 1
                    i+=1
                    if count == 0:
                        if len(ans) > (j-i+1):
                            ans = s[i:j+1]
                    
            j= j + 1
                        
        return ans
