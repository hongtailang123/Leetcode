class Solution(object):
    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res = []
        used = []
        nums.sort()
        self.dfs(res, [], nums, used)
        return res
    
    def dfs(self, res, element, nums, used):
        if (len(element) == len(nums)):
            res.append(element)
            return
        else:
            for i in range(len(nums)):
                if (i in used or (i != 0 and nums[i] == nums[i - 1] and not (i - 1) in used)):
                    continue
                else:
                    used.append(i)
                    self.dfs(res, element + [nums[i]], nums, used)
                    used.remove(i)
