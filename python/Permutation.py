class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """        
        res = []
        self.dfs(res, [], nums)
        return res
    
    def dfs(self, res, element, nums):
        if not nums:
            res.append(element)
        else:
            for i in range(len(nums)):
                self.dfs(res, element + [nums[i]] , nums[:i] + nums[i+1:])
