from collections import deque
class Solution(object):
    def minReorder(self, n, connections):
        """
        :type n: int
        :type connections: List[List[int]]
        :rtype: int
        """
        bfs_ans = self.bfs(n,connections)
        neighbour = [[] for _ in range(n)]

        for x,y in connections:
            neighbour[x].append(y) #actual edges
            neighbour[y].append(-x) #assumed edges #important
        visited = [0]*n
        steps = 0
        return self.dfs(neighbour,0,visited)
    
    def dfs(self,neighbour,curr,visited):
        steps = 0
        visited[curr] = 1
        for node in neighbour[curr]:
            if visited[abs(node)] == 0:
                visited[abs(node)] = 1
                steps += self.dfs(neighbour,abs(node),visited)
                if node > 0:
                    steps+=1
                
        return steps

        

        

    def bfs(self, n, connections):
        edges = [[] for _ in range(n)]
        neighbour = [[] for _ in range(n)]

        for x,y in connections:
            edges[x].append(y)
            neighbour[x].append(y)
            neighbour[y].append(x)

        q = collections.deque()
        q.append(0)
        visited = [0]*n
        visited[0] = 1
        step = 0
        while(q):
            curr = q.popleft()
            for node in neighbour[curr]:
                if visited[node] == 0:
                    if curr not in edges[node]: #important
                        step += 1
                    q.append(node)
                    visited[node] = 1
        return step
        
