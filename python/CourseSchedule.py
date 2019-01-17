class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        
        graph = [[] for _ in range(numCourses)]
        visited = [0 for _ in range(numCourses)]
        taken = [0 for _ in range(numCourses)]
        
        for pair in prerequisites:
            course, pre = pair
            graph[course].append(pre)
                
        for i in range(numCourses):
            if not self.dfs(i, visited, taken, graph):
                return False
        
        return True
    
    def dfs(self, i, visited, taken, graph):
        if taken[i]:
            return True
        
        if visited[i]:
            return False
        
        visited[i] = 1
        
        for pre in graph[i]:
            if not self.dfs(pre, visited, taken, graph):
                return False
        
        visited[i] = 0
        taken[i] = 1
        
        return True
