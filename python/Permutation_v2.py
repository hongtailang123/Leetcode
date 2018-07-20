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
        if len(element) == len(nums):
            res.append(element);
            return
        else:
            for i in range(len(nums)):
                if nums[i] in element:
                    continue
                else:
                    self.dfs(res, element + [nums[i]], nums)
