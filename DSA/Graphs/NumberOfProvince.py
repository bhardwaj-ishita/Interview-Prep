'''
  DFS traversal in adjacency matrix
  
  Here I use a visited array, because there is a count of provinces and it's not random like island. It is an adjacencey matrix. 
  In islands it was not an adjacency matrix but just a matrix/board
  '''
  
  class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        V = len(isConnected[0])
        count = 0
        visited = [False for _ in range(V)]
        for i in range(V):
            if not visited[i]:
                count+=1
                self.dfs(i,visited,isConnected)
        return count
    
    def dfs(self,n,visited,graph):
        visited[n] = True
        for i in range(len(visited)):
            if graph[n][i] == 1 and not visited[i]:
                self.dfs(i,visited,graph)
        return 
