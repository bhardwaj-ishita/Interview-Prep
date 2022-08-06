#Given is the edge list
#Print the adjacency list of it

def Solution:
  def adjacency(self, V, edges):
    no_nodes = V
    no_edges = len(edges)
    
    ans = [[] for _ in edges]
    for u,v in edges:
      ans[u].append(v)
      
    return ans
