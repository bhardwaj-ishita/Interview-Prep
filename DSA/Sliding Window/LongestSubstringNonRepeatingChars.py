#Using Data Structure Queue
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        n = len(s)
        i,j = 0,0
        store = list()
        ans = 0
        
        while j < n:
            
            if s[j] not in store:
                store.append(s[j])
                ans = max(ans,len(store))
                
                
            elif s[j] in store:
                while s[j] != store[0]:
                    store.pop(0)
                store.pop(0)
                store.append(s[j])
                ans = max(ans,len(store))
                
            j+=1
        
        return ans
      

#Using Map and sliding window
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        n = len(s)
        i,j = 0,0
        store = dict()
        ans = 0
        
        while j < n:
            if s[j] in store:
                store[s[j]] +=1
            else:
                store[s[j]] = 1
            
            if len(store) == (j-i+1):
                ans = max(ans,len(store))
                
                
            elif len(store) != (j-i+1):
                while len(store) != (j-i+1):
                    store[s[i]] -= 1
                    if store[s[i]] == 0:
                        store.pop(s[i])
                    i+=1
                ans = max(ans,len(store))
                
            
            j+=1
        
        return ans
