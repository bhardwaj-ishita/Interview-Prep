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


#latest addition 13/07
from collections import deque
class Solution:
    '''
    Operation	    Description	Time Complexity
    append(x)	    Adds x to the right end of the deque.	                        O(1)
    appendleft(x)	Adds x to the left end of the deque.	                        O(1)
    pop()	        Removes and returns an element from the right end of the deque.	O(1)
    popleft()	    Removes and returns an element from the left end of the deque.	O(1)
    '''
    def topoSort(self, V, edges):
        # Code here
        
        def dfs(node):
            visited[node] = 1
            for neigh in graph[node]:
                if not visited[neigh]:
                    dfs(neigh)
            
            q.appendleft(node)
        
        graph = [[] for _ in range(V)]
        visited = [0]*V
        for x,y in edges:
            graph[x].append(y)
            
        q = deque()
        for node in range(V):
            if not visited[node]:
                dfs(node)
        
        ans = []
        for i in range(len(q)):
            ans.append(q.popleft())
            
        return ans
          
        
        
