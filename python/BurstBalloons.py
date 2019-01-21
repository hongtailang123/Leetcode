class Solution(object):
    def maxCoins(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        newNums = [1] + [num for num in nums] + [1]
        n = len(newNums)
        dp = [[0] * n for _ in range(n)]
        
        for k in range(2, n):
            for left in range(0, n - k):
                right = left + k
                for i in range(left + 1, right):
                    dp[left][right] = max(dp[left][right], newNums[i] * newNums[left] * newNums[right] + dp[left][i] + dp[i][right])            
    
        return dp[0][n - 1]
