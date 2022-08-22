#Method 2: Kahn's method
'''
Here first find the degree of incoming of each node
Then enqueue all the nodes with 0 degree
Then start the BFS
dequeue the node
decrement the degree for all the nodes who depended on the node
if anyone's degree becomes 0 then enqueue it
and go on with this loop till the queue is empty

if the index of order == V:
then return order list

else a cycle was found and hence Topological sort can't be applied to Directed Cyclic Graph
hence return []
'''
    #Function to return list containing vertices in Topological order.
    def topoSort(self, V, adj):
        
        #check the incoming degree for every node
        degree = [0]*V
        for i in adj:
            for j in i:
                degree[j] += 1
        
        #append the nodes in the queue which have degree 0
        queue = []
        for i in range(0,len(degree)):
            if degree[i] == 0:
                queue.append(i)
        
        y = 0
        order = [0]*V
        while queue:
            node = queue.pop(0)
            order[y] = node
            y+=1
            for x in adj[node]:
                degree[x] -= 1
                if degree[x] == 0:
                    queue.append(x)
        
        if y != V:
            return []
        return order
