#here the returning of the pos variable makes sure of the ordering in the order array

class Solution:
    
    #Function to return list containing vertices in Topological order.
    def topoSort(self, V, adj):
        # Code here
        visited = [False]*V
        order = [0]*V
        pos = V-1
        for i in range(V):
            if not visited[i]:
                pos = self.dfs(i,adj,visited,order,pos)
        
        return order
        
    def dfs(self,node,adj,visited,order,pos):
        visited[node] = True
        neighbours = adj[node]
        for nodes in neighbours:
            if not visited[nodes]:
                pos = self.dfs(nodes,adj,visited,order,pos)
                
        order[pos] = node
        return pos - 1
