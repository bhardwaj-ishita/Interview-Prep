#the whole funda here is that, instead of checking for the whole graph in one go if cycle exist or not, we check the current path if the cycle exist, if not then we backtrack the array and then start again
class Solution:
    def isCycle(self, V, edges):
        # code here
        
        def dfs(node):
            visited[node] = 1
            cp[node] = 1
            for neigh in graph[node]:
                if not visited[neigh]:
                    ans = dfs(neigh)
                    if ans:
                        return True
                elif cp[neigh]:
                    return True
            cp[node] = 0 #backtracking is important in CurrentPath
            return False
            
        
        graph = [[] for _ in range(V)]
        for u,v in edges:
            graph[u].append(v) #directed
        
        visited = [0]*V
        cp = [0]*V
        
        for node in range(V):
            if not visited[node]:
                ans = dfs(node)
                if ans:
                    return True
        return False
        
