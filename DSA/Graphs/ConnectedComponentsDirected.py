'''
The thought is all different disconnected nodes are provinces
So we'll hold a dfs
And at any point we meet a dead end or already visited, we return back
There will be a chance that there are nodes that are not connected to these bunch of cluster of nodes, so when we for loop in main function and find a not visited node,
Then it is a part of another province hence, count++
'''
class Solution:
  def main(self, V, adj):
    visited = [False for _ in range(V)]
    count = 0
    for i in range(V):
      if not visted[i]:
        count+=1
        self.dfs(i,visited,adj)
    return count
  
  def dfs(self,n,visited,adj):
    visited[n] = True
    neighbours = adj[n]
    for nodes in neighbours:
      if not visited[nodes]:
        self.dfs(nodes,visited,adj)
    return
