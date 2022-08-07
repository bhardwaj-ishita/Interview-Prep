#So these Range Query type of questions are done by Segment Trees too, along with Merge Sort

'''
arr is the laptop(price,rating)
n = lenght of arr
queries = range(x,y) price
q = number of queries

we find the lenght of segment tree
construct the segment tree
sort the array
run the queries
For each query find the best rating in the given price range

return ans list with the best ratings in each query
'''
def main(self, arr, n, queries, q):
  i = 0
  while i < len(arr):
    i += 1
  n = pow(2,i)*2-1
  segment = [0]*n
  self.constructSeg(arr,segment,0,len(arr)-1,0)
  ans = []
  arr.sort()
  while i < q:
    x = queries[i][0]
    y = queries[i][1]
    rating = self.findBest(segment,x,y,arr[0][0], arr[len(arr)],0)
    ans.append(rating)
    
  return ans
    

'''
arr = given array = laptops[price,rating]
segment = the segment tree array we are going to construct
low = 0
high = len(arr)
low and high are pointing to positions of arr here
i is the position of segment tree here
all the values of arr are at the leaf nodes of segment tree
And we are going to build the tree from bottom up. leaf to root

Remember we are finding max rating in the given range of price
So we put values according to rating
But we'll need the price too, so save the pair
'''
def constructSeg(self, arr, segment, low, high, i):
  #base condition: place where we push the values we know i.e. of arr
  if low == high:
    segment[i] = arr[low]
  
  #hypothesis: go till the leaf node
  mid = (low + (high-low))//2
  self.constructSeg(arr,segment,low,mid,2*i+1)
  self.constructSeg(arr,segment,mid+1,high,2*i+2)
  
  #induction: as we come up we put the values, we save the max rated laptop with their price
  if segment[2*i+1][1] >= segment[2*i+2][1]:
    segment[i] = segment[2*i+1]
  else:
    segment[i] = segment[2*i+2]
    

    
'''
here segment is the segment tree with the best rating at each node in a range

x and y are price constraints which we'll use for partial, total and no overlap
and we'll return the max rating of the bunch

low and high are the prices of 1st laptop and last laptop

i is the position in segment tree

total overalp is when (x,y) C (low,high)
  we return the rating itself
no overlap is when (x,y) intersect (low,high) at all
  return max integer
partial overlap when (low,high) lie in (x,y) but don't cover it fully
  we go deeper in the segment tree until we find total or no overlap
'''
def findBest(self, segment, x, y, low, high, i):
  #total overlap
  if low <= x and y <= high:
    return segment[i][1]
  #no overlap
  if x >= low or high <= high:
    return -1*sys.maxsize
  
  mid = (low + (high-low))//2
  return max(self.findBest(segment,x,y,low,mid,2*i+1),self.findBest(segment,x,y,mid+1,high,2*i+2))
    
  
  
  
