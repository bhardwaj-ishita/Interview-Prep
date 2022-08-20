def shortestPath(s,d,adj):
    prev = [Null]*V #prev is to store the next in the path of node i
    source = s 
    destination = d
    BFS()
    reconstructPath(s,d,prev)

    def BFS():
        queue = [0]
        visited = [False]*V

        while queue:
            node = queue.pop(0)
            neighbours = adj[node]
            for nodes in neighbours:
              if not visited[nodes]:
                    queue.append(nodes)
                    visited[nodes] = True
                    prev[nodes] = node

    def reconstructPath(s,d,prev):
        path = []
        node = d
        while node:
            path.append(node)
            node = prev[node]

        #if s and and are connected
        if path[0] == s:
            return path
        #else not connected
        return []
