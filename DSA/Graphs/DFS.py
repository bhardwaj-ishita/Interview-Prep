class Solution:
    
    #Function to return a list containing the DFS traversal of the graph.
    #we are already given an adjacency list
    #make the visited array
    #for 0 --> V-1, traverse for all nodes
    #when you'll enter the dfs function, if the node is already visited then it will be returned
    #else we'll append the node and go for it's neighbours
    #unitl we are at the dead end or we have already visited the node we will dfs or else we will return 
    
    def dfsOfGraph(self, V, adj):
        visited = [False for _ in range(V)]
        ans  = []
        for i in range(V):
            self.dfs(i,visited,adj,ans)
        return ans
        
    def dfs(self, n, visited, adj, a):
        if visited[n]:
            return
        visited[n] = True
        a.append(n)
        neighbour = adj[n]
        for nodes in neighbour:
            self.dfs(nodes,visited,adj,a)
        return
