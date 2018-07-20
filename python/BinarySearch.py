class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if target < -9999 or target > 9999 or not nums:
            return -1
        else:
            left = 0
            right = len(nums) - 1
            while left <= right:
                mid = left + (right - left) / 2
                if nums[mid] == target:
                    return mid
                elif nums[mid] < target:
                    left = mid + 1
                else:
                    right = mid - 1
        return -1
