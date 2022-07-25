#The question is similar to Pick Toys
#You have to choose continuous fruits, in a farm, but there are two conditions
#1. At most you can pick two types of fruits. Total count of these two types can be unlimited. But there should be only two types
#2. And you should pick fruits from each tree. That is, You can not skip a tree if it is a different type. Continuous picking of fruits

#1. point is an upper limit. Worst case scenerio if you want to pick different types it is max 2
#But if you only find 1 type of fruits, that is good too. That is, it is an answer too

class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        n = len(fruits)
        i,j = 0,0
        farm = dict()
        ans = 0
        while j < n:
            if fruits[j] in farm:
                farm[fruits[j]] += 1
            else:
                farm[fruits[j]] = 1
            
            if len(farm) <= 2:
                ans = max(ans,j-i+1)
                
            elif len(farm) > 2:
                while len(farm) > 2:
                    if fruits[i] in farm:
                        farm[fruits[i]] -= 1
                    if farm[fruits[i]] == 0:
                        farm.pop(fruits[i])
                    i+=1
                ans = max(ans,j-i+1)
            j+=1
        
        return ans
