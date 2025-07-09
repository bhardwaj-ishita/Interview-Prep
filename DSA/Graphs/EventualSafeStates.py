#the whole problem is about a graph which have terminal nodes. i.e. a path that ends. and we need to tell which nodes 
#lead to an end, all their paths. 
#now what are the nodes that don't end --> ones that are part of a cycle.
#so we need to find all the nodes that are part of a cycle 

class Solution:    
    def eventualSafeNodes(self, V : int, adj : List[List[int]]) -> List[int]:
        # code here
        
        def dfs(node):
            visited[node] = 1
            cp[node] = 1
            
            for neigh in adj[node]:
                if not visited[neigh]:
                    bl = dfs(neigh)
                    if bl:
                        return True
                elif cp[neigh]:
                    return True
            cp[node] = 0
        
        #graph = [[] for _ in range(V)]
        #for u,v in adj:
        #    graph[u].append(v) #directed
            
        visited = [0]*V
        cp = [0]*V
        ans = []
        
        for node in range(V):
            if not visited[node]:
                dfs(node)
                    
        for i in range(V):
            if cp[i] == 0:
                ans.append(i)
        
        return ans
            
