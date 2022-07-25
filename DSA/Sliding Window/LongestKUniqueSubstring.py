#Map and counter approach, just like Anangram problem

class Solution:
    def longestKSubstr(self, s, k):
        # code here
        n = len(s)
        i,j = 0,0
        store = dict()
        count = k
        ans = -1
        while j < n:
            if s[j] not in store:
                store[s[j]] = 1
                count -= 1
            elif s[j] in store:
                store[s[j]] += 1
            
            if count == 0:
                ans = max(ans,j-i+1)
            
            if count < 0:
                while count!=0:
                    if s[i] in store:
                        store[s[i]] -= 1
                        if store[s[i]] == 0:
                            store.pop(s[i])
                            count += 1
                    i+=1
            
            j+=1
        return ans
