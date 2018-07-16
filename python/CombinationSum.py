class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        res = []
        self.dfs(res, [], candidates, target, 0)
        return res
    
    def dfs(self, res, path, candidates, target, index):
        if target < 0:
            return
        if target == 0:
            res.append(path)
            return
        for i in range(index, len(candidates)):
            self.dfs(res, path + [candidates[i]], candidates, target - candidates[i], i)
