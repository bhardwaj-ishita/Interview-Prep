#Count of pairs batane hai, condition:
#(a[i] - a[j] <= k) hai such that i<j. Array is unsorted.
#This is the question

---------------------------------------------------------------------------------------------------------------------------------------------------

#This is not the solution for the question.
'''Two pointer: this method can only work if we can sort the array(no condition like i<j) or given a sorted array(condition is i<j but the array is already sorted).
But Counting Pairs question has an unsorted array with condition i<j. So not possible'''
class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        i,j = 0 ,len(numbers)-1
        while i < j:
            if a[i] + a[j] == target:
                return [i+1,j+1]
            elif a[i] + a[j] > target:
                j = j - 1
            elif a[i] + a[j] < target:
                i = i + 1

------------------------------------------------------------------------------------------------------------------------------------------------------                
                
'''What the difference is that we need to find all pairs with difference less than or equal to k.
By using hashmap here, we reduced o(n) to O(1) because we can get a key in O(1) time
But when we need to find a range of values, we'll need to traverse the hashmap, which doesn't solve the problem'''
class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        dict = {}
        for i,j in enumerate(numbers):
            req = target - j
            if req in dict:
                return [dict[req],i]
            else:
                dict[j] = i
                
'''Two Sum: These types of questions are possible to solve this way even if we have an i<j condition when we know what value we need to search. 
It does not work for a range but a constant. For a range, we use count inversion method(merge sort) or AVL trees.'''

-------------------------------------------------------------------------------------------------------------------------------------------------------

#What is merge sort?
#It is a divide and conquer algorithm. Uses extra space. Sorts array in O(nlogn) time. First we divide and then while merging we sort.
'''
So we started with the base condition i.e. the moment there is only one element in the block
return it
Next we appoint a mid for the array
We make a left and a right array
We keep doing it until the base condition
Now as we start returning we'll start merging the left and right arrays in the arr(original array)
'''
class Solution:
    
    def merge(self, arr):
        if len(arr) > 1:
            mid = len(arr)//2
            L = arr[:mid]
            R = arr[mid:]
            self.merge(L)
            self.merge(R)
            
            i,j,k = 0,0,0
            while i < len(L) and j < len(R):
                if L[i] < R[j]:
                    arr[k] = L[i]
                    i += 1
                else:
                    arr[k] = R[j]
                    j += 1    
                k += 1
            
            while i < len(L):
                arr[k] = L[i]
                k += 1
                i += 1   
            while j < len(R):
                arr[k] = R[j]
                j += 1
                k += 1
                
-------------------------------------------------------------------------------------------------------------------------------------------------
#So how do you think merge sort is going to help in solving the original problem?
'''
What we'll do is we'll divide the array until there is exactly one element in it. 
Now while merging it, we know the Right array, in order, comes after the Left array i.e. i<j
So while this condition is holding true, we'll check for the condition arr[i] <= k + arr[j]
If we find an i where the condition is true, then count++ and then sort the array
Keep doing it until we've sorted the whole array

Now even though we are sorting the array, but we get to keep the count and the original position maintained throughout
The left array will always be at a lower position than the right array i.e have a lower index
'''




