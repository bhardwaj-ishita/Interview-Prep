def slotWheels(history):
  res = [-1 for p in range(len(history[0]))]
  values = []
  for i in history:
    values.append(strArray(i))
   
  for x in values:
    for y in range(len(x)):
      if res[y] < x[y]:
        res[y] = x[y]
        
  return sum(res)

def strArray(i):
  ans = []
  num = int(i)
  while num!=0:
    val = num%10
    ans.append(val)
    num = num//10
    
  ans.sort()
  return ans
