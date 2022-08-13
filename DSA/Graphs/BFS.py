class Solution:
    
    #Function to return Breadth First Traversal of given graph.
    def bfsOfGraph(self, V, adj):
        # code here
        visited = [False]*V
        q = [0]
        ans = []
        while q:
            node = q.pop(0)
            if not visited[node]:
                visited[node] = True
                ans.append(node)
                for i in adj[node]:
                    q.append(i)
        
        return ans
