class Solution:
    
    #Function to detect cycle in a directed graph.
    def isCyclic(self, V, adj):
        # code here
        visited = [False]*V
        recStack = [False]*V
        for i in range(V):
            if not visited[i]:
                if self.detect(i,adj,visited,recStack):
                    return True
        return False
        
    def detect(self, node, adj, visited, recStack):
        visited[node] = True
        recStack[node] = True
        neighbours = adj[node]
        for nodes in neighbours:
            if not visited[nodes]:
                if self.detect(nodes,adj,visited,recStack):
                    return True
            elif recStack[nodes]:
                return True
        recStack[node] = False    
        return False
