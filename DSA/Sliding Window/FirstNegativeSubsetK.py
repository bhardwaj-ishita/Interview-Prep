'''
We start with a curr list. and i = 0 and j  = 0
Concept is same, sliding window
We'll check for all values if they are negetive and save them for future use

If window size == k
Then check if we have a negetive element in curr to use
if no then ans.append(0)
else append the first element of curr

Now we will be incrementing i. So the previous value of ith index will not be of any use
So we need to remove it from curr too.
If a[i] is in curr then remove else keep going on

By doing this the first negetive element will always be there in the list. If not, then there is no first
negetive element
'''
def printFirstNegativeInteger( a, n, k):
    # code here

    ans = []
    curr = []
    i,j = 0,0
    while j < n:
        if a[j] < 0:
            curr.append(a[j])
            
        if j - i + 1 ==k:
            if curr:
                ans.append(curr[0])
            else:
                ans.append(0)
            if curr and a[i] == curr[0]:
                del curr[0]
            i += 1
            
        j += 1
    
    return ans
