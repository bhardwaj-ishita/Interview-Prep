import collections
class Solution:
	def isCycle(self, V, edges):
		#Code here
		
		#for bfs the queue needs to have a parent node in it, so specify it in the function if you're creating one. else it fails for a disconnected graph            
		#and it should be filled with the parent of the new disconnected graph
		def bfs(node):
		    q.append(node)
			    visited[node] = 1
			    parent[node] = -1
		    while(q):
			node = q.popleft()
			for neigh in graph[node]:
			    if visited[neigh] == 0:
				visited[neigh] = 1
				parent[neigh] = node
				q.append(neigh)
			    else:
				if visited[neigh] == 1 and parent[node] != neigh:
				    return True
		    return False
            
		
		graph = [[] for _ in range(V)]
		for u,v in edges:
		    graph[u].append(v)
		    graph[v].append(u)
		    
		visited = [0]*V 
		parent = [-1]*V
		q = collections.deque()
		 
		for node in range(V):
		    if visited[node] == 0:
			ans = bfs(node)
			if ans:
			    return True
		return False
