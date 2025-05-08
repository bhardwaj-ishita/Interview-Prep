class Solution(object):
    def validPath(self, n, edges, source, destination):
        """
        :type n: int
        :type edges: List[List[int]]
        :type source: int
        :type destination: int
        :rtype: bool
        """
        graph = [[] for i in range(n)] #arr in arr
        #graph = collections.defaultdict(list)

        for u,v in edges:
            graph[u].append(v)
            graph[v].append(u) #it was bidirectional and edges were given

        visited = [0]*n

        return self.dfsrec(graph, source, destination, visited)

    def dfsrec(self, graph, source, destination, visited):
        if source == destination:
            return True
        visited[source] = 1
        for neighbour in graph[source]:
            if visited[neighbour] != 1:
                if self.dfsrec(graph, neighbour, destination, visited):
                    return True
        return False

    def dfsstack(self, graph, source, destination, visited):
        #stack for dfs or queue for bfs
        stack = [source] #pop or append
        visited[source] = 1
        while stack:
            current = stack.pop()
            for neighbour in graph[current]:
                if neighbour == destination:
                    return True
                if visited[neighbour] != 1:
                    visited[current] = 1
                    queue.append(neighbour)
        return False

    def bfs(self,graph, source, destination, visited):
        queue = [source] 
        visited[source] = 1
        while queue:
            current = queue.pop(0)
            if current == destination:
                return True
            for neighbour in graph[current]:
                if visited[neighbour] != 1:
                    visited[current] = 1
                    queue.append(neighbour)
        return False

    #def DSU(self, n, graph, source, destination):
