class Solution:
    
    #Function to detect cycle in an undirected graph.
	def isCycle(self, V, adj):
		#Code here
		visited = [False] * V
		for i in range(V):
		    if not visited[i]:
		        if self.detect(i,-1,adj,visited):
		            return True
		return False
		
	def detect(self, child, parent, adj, visited):
	    visited[child] = True
	    neighbours = adj[child]
        for nodes in neighbours:
            if visited[nodes] and nodes != parent:
                return True
            elif not visited[nodes]:
	            if self.detect(nodes,child,adj,visited):
	                return True
	                
	    return False
