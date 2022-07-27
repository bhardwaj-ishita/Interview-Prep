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
