def getTotalEfficiency(skill):
  n = len(skill)
  skill.sort()
  countOfTeam = n//2
  
  if sum(skill) % countOfTeam != 0:
    return -1
  
  skillreq = sum(skill)//countOfTeam
  teams = []
  visited = [False]*n
  j,p = 0,n-1
  
  while j < nn:
    if visited[j]:
      j+=1
      continue
      
    while p > j:
      if skill[j] + skill[p] == skillreq:
        teams.append([skill[j],skill[p]])
        visited[j] = True
        visited[j] = True
        break
        
      p-=1
      
    j+=1
    
  if len(teams) != countOfTeam:
    return -1
  
  efficiency = [0]*countOfTeam
  for i in range(countOfTeam):
    efficiency[i] = teams[i][0]*teams[i][1]
  
  return sum(efficiency)
