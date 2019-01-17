class Solution(object):
    def findOrder(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: List[int]
        """
        graph = [[] for _ in range(numCourses)]
        visited = [0 for _ in range(numCourses)]
        taken = [0 for _ in range(numCourses)]
        res = []

        for pair in prerequisites:
            course, pre = pair
            graph[course].append(pre)

        for i in range(numCourses):
            if not self.dfs(i, visited, taken, graph, res):
                return []
            
        return res
    

    def dfs(self, i, visited, taken, graph, res):
        if taken[i]:
            return True

        if visited[i]:
            return False

        visited[i] = 1

        for pre in graph[i]:
            if not self.dfs(pre, visited, taken, graph, res):
                return False

        visited[i] = 0
        taken[i] = 1
        res.append(i)

        return True
