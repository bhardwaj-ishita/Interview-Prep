#detect the cycle
#detect cycle in directed graph
#detect count of nodes in a directed graph
#can we count the nodes of only the longest cycle?

#in the cp list, we store the time/counter and get the length. The moment we get the cycle, we store the length and keep comparing in the future


class Solution(object):
    def longestCycle(self, edges):
        """
        :type edges: List[int]
        :rtype: int
        """
        V = len(edges)
        visited = [0]*V
        cp = [0]*V
        longestCycle = [-1]
        '''
        edges[i] : 3 3 4 2 3 (neighbour)
              i  : 0 1 2 3 4 (node)
        '''

        def dfs(counter,node):
            visited[node] = 1
            cp[node] = counter
            #because only one neighbour is there for a node -> no loop
            neigh = edges[node]
            if (neigh != -1): 
                if not visited[neigh]:
                    ans = dfs(counter+1,neigh)
                    if ans:
                        return True
                elif cp[neigh] != 0:
                    currentCycle = cp[node] - cp[neigh] + 1
                    longestCycle[0] = max(longestCycle[0],currentCycle)
            cp[node] = 0

        for i in range(V):
            if not visited[i]:
                dfs(1,i)    

        return longestCycle[0]

        
