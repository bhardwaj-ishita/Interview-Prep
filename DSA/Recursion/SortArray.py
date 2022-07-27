class Solution:
    def sortArray(self, a: List[int]) -> List[int]:
        if len(a) <= 1:
            return a
        #this will divide the array
        mid =  len(a)//2
        left = a[:mid]
        right = a[mid:]
        self.sortArray(left)
        self.sortArray(right)

        self.merge(left,right,a)
        return a
            
            
    def merge(self, left, right, a):
        #this will merge the arrays left and right in the original array nums
        #i is the pointer for left
        #j is the pointer for right
        #k is the pointer for original array a
        i,j,k = 0,0,0

        while i < len(left) and j < len(right):
            if left[i] < right[j]:
                a[k] = left[i]
                i+=1
            else:
                a[k] = right[j]
                j+=1
            k+=1
        
        while i < len(left):
            a[k] = left[i]
            i+=1
            k+=1
        while j < len(right):
            a[k] = right[j]
            j+=1
            k+=1
            
#In complex recursion way: Just to understand recursion

def sort(self, arr):
    if len(arr) == 1 or arr is None:
        return arr
    temp = arr.pop()
    self.solve(arr)
    self.insert(arr,temp)
    return arr

def insert(self, arr, temp):
    if temp >= arr[-1] or len(arr) == 0:
        arr.append(temp)
        return 
    val = arr.pop()
    self.insert(arr,temp)
    arr.append(val)
    return
