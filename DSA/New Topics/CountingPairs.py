#Count of pairs batane hai, condition:
#(a[i] - a[j] <= k) hai such that i<j. Array is unsorted.
#This is the question

#This is not the solution for the question.
'''What the difference is that we need to find all pairs with difference less than or equal to k.
By using hashmap here, we reduced o(n) to O(1) because we can get a key in O(1) time
But when we need to find a range of values, we'll need to traverse the hashmap, which doesn't solve the problem'''
class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        dict = {}
        for i,j in enumerate(numbers):
            req = target - j
            if req in dict:
                return [dict[req],i+1]
            else:
                dict[j] = i+1
                
'''Two Sum: These types of questions are possible to solve this way even if we have an i<j condition when we know what value we need to search. 
It does not work for a range but a constant. For a range, we use count inversion method(merge sort) or AVL trees.'''
