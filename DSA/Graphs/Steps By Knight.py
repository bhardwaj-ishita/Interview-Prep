import collections
class Solution:
	def minStepToReachTarget(self, knightPos, targetPos, n):
	    
    	def bsf(i,j,x,y):
            #2. create the 8 possible position list so you don't have to write more code
            pos = [[1,2],[1,-2],[-1,2],[-1,-2],
                [2,1],[2,-1],[-2,1],[-2,-1]]
            
            #3. levels of bsf = edges from the source = min steps to reach destination
            visited = [[0 for _ in range(n)] for _ in range(n)]
            q = collections.deque()
            q.append([i,j])
            visited[i][j] = 1
            steps = 0
            
            while(q):
                size = len(q)
                while(size>0):
                    first,second = q.popleft()
                    if first == x and second == y:
                        return steps
                    for a,b in pos:
                        new_i = first + a
                        new_j = second + b
                        if 0 <= new_i < n and 0 <= new_j < n and visited[new_i][new_j] == 0:
                            q.append([new_i,new_j])
                            visited[new_i][new_j] = 1
                
                    size -= 1
                steps += 1
            return -1

	    #there are in total three issues to deal with here
        #1. change chess position acc to 0 indexed array
        kp_i = n - knightPos[1] 
        kp_j = knightPos[0] - 1
        tp_i = n - targetPos[1] 
        tp_j = targetPos[0] - 1
        return bsf(kp_i,kp_j,tp_i,tp_j)
		#Code here
		
	"""
	1. bsf will always give the min steps to reach a point
	2. the chessboard positioning and 0 indexed matrix positioning are different
	3. the knight walks in 2.5 steps(dhai ki chaal)
	    so from a point it can take 8 possible positions. for that we will create a array to store the positions
	4. answer is the number of steps. And if you take a look, the levels of traversal 
	    in bsf are basically the min no. of edges/steps it will take to reach the destination
	5. so basically we need to know in bsf when are we changing levels and record
	"""
