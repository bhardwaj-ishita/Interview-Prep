#Using detect cycle for directed graphs algo
#Remember here, in general cycle True is for detected cycle. So take care of boolean returns
'''
if not self.dfs(i,visited,adj, recStack):
    return False
                    
here if dfs is coming True, it means that schedule is possible. If schedule is possible --> keep checking further
but if it's coming False, then it means there is a cycle, and return False
'''
class Solution:
    def canFinish(self, course: int, pre: List[List[int]]) -> bool:
        adj = [[] for i in range(course)]
        for u in pre:
            adj[u[0]].append(u[1])
            
        
        visited = [False]*course
        recStack = [False]*course
        
        for i in range(course):
            if not visited[i]:
                if not self.dfs(i,visited,adj, recStack):
                    return False
        return True
    
    def dfs(self, node, visited, adj, recStack):
        visited[node] = True
        recStack[node] = True
        
        neighbours = adj[node]
        for nodes in neighbours:
            if not visited[nodes]:
                if not self.dfs(nodes,visited,adj,recStack):
                    return False
            elif recStack[nodes]:
                return False
        
        recStack[node] = False
        return True
            
        
        
#Using Kahn's algo to detect DAG 
class Solution:
    def canFinish(self, course: int, pre: List[List[int]]) -> bool:
        adj = [[] for i in range(course)]
        for u in pre:
            adj[u[0]].append(u[1])
        
        degree = [0]*course
        for i in adj:
            for j in i:
                degree[j] += 1
        
        queue = []
        for i,j in enumerate(degree):
            if j == 0:
                queue.append(i)
        
        x = 0
        while queue:
            node = queue.pop(0)
            x+=1
            for y in adj[node]:
                degree[y] -= 1
                if degree[y] == 0:
                    queue.append(y)
        
        if x != course: #this condition tells whether a cycle is detected or not
            return False
        return True
