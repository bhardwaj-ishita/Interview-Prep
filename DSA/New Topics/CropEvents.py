'''
We have n fields
And there are k events
Event 1: plant a crop in ith field with water capacity c
Event 2: water from lth field to r-1th field with w water

If c <= w then the plant dies
Every time a crop is planted in the field the old crop is removed
And watering in a field with c > w, does not diminish the capacity of the crop

Find in each Event 2, how many crops die.
Return a list
'''
def solution(n,k,event):
  i = 0
  ans = []
  field = [-1 for x in range(n)]
  while i < k:
    dead = 0
    if event[i][0] == 1:
      field[event[i][1]] = event[i][2]
    elif event[i][0] == 2:
      l = event[i][1]
      r = event[i][2]
      w = event[i][3]
      while l < r:
        if field[l] != -1 and field[l] <= w:
          dead += 1
        l+=1
    ans.append(dead)
    i+=1
  return ans
