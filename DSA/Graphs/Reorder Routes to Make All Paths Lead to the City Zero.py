'''
1) For BFS
so the whole question is we need to check from the capital if everything is indirectly connected to each other:
we've been given no same path is reiterated again. and there is no cycle
Acyclic and directional

So i store the edges(directional) and neighbours(bidirectional) in separate maps.

you start from zero and check for all neighbours
and for each neighbour check if the parent is in the edges:
if yes then skip else step += 1
also keep the nodes marked visited. because they won't be iterated again. 

2) For DFS
So, our task is to count the number of edges in a tree rooted at node '0' that are directed from the parent node to a child node.
Every child should be able to reach the parent


remeber in recursion, parent to child we are traversing. and we have kept that as positive. 
But we should be able to reach from the child to the parent
so if node>0
then step +=1

'''

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
        
