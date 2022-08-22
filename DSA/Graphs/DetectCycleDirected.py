'''
The thing is when we only use visited, we don't know why a node has been marked visited
Mabye because while traversing a continuously linked set of nodes or maybe it was visited before
but it pointed somewhere else, like 5->4->4->3->2->1->0 , hence it is marked visited
Now here 0 will be visited first and nothing to point towards

Now for recStack we mark true for all the nodes in one traversal, and if you end up again 
on an already visited node, then it is true
But if you eneded up on a node which is visited already, but never traversed, 
it means that, that the next node in traversal is this particular node, and when we traversed it, we didn't
find any loop then why do you think when you'll get on the same node again, you'll find one
, so break out of the traversal already because you're at a dead end.

'''
class Solution:
    
    #Function to detect cycle in a directed graph.
    def isCyclic(self, V, adj):
        # code here
        visited = [False]*V
        recStack = [False]*V
        for i in range(V):
            if not visited[i]:
                if self.detect(i,adj,visited,recStack):
                    return True
        return False
        
    def detect(self, node, adj, visited, recStack):
        visited[node] = True
        recStack[node] = True
        neighbours = adj[node]
        for nodes in neighbours:
            if not visited[nodes]:
                if self.detect(nodes,adj,visited,recStack):
                    return True
            elif recStack[nodes]:
                return True
        recStack[node] = False    
        return False
