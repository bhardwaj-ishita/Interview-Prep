from collections import deque
class Solution(object):
    def findOrder(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: List[int]
        """
        
        #basically comlete all courses(full traversal)
        #prerequisites should be completed before the child course of it
        #topological sort

        '''
        BFS:
        - find indegree
        - add 0 degree
        - do bfs and subtract degree as traversal happaening

        DFS:
        - traverse all the nodes
        - when reach the leaf, add it to the deque
        - the whole intention is to add the final courses first and their parents then once all children are in
        - but we use deque and appendleft because we are filling in the sort in opp direction
        '''
        V = numCourses
        indegree = [0]*V
        graph = [[] for _ in range(V)]

        for x,y in prerequisites:
            graph[y].append(x)

        for i in graph:
            for j in i:
                indegree[j] += 1

        q = deque()
        for i in range(0,V):
            if indegree[i] == 0:
                q.append(i)

        ans = []
        while(q):
            node = q.pop()
            ans.append(node)
            for neigh in graph[node]:
                indegree[neigh] -= 1
                if indegree[neigh] == 0:
                    q.append(neigh)
        
        if len(ans) == V: 
            return ans 
        else: 
            return []
