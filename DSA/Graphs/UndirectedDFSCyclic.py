#the moment you get a true, get out of the recursion stack and return true all the way
class Solution:
	def isCycle(self, V, edges):
		#Code here
		
		def dfs(parent,node):
		    visited[node] = 1
		    for neigh in graph[node]:
		        if visited[neigh] == 0:
		            ans = dfs(node,neigh)
		            if ans:
		                return True
	            elif neigh != parent and visited[neigh] == 1:
                    return True
		
		graph = [[] for _ in range(V)]
		for u,v in edges:
		    graph[u].append(v)
		    graph[v].append(u)
		visited = [0]*V 
		parent = -1
		for node in range(V):
		    if visited[node] == 0:
		        ans = dfs(parent,node)
		        if ans:
		            return True
		return False
