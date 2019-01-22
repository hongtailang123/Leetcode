class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if not prices:
            return 0
        
        length = len(prices)
        minValue = prices[0]
        maxValue = prices[length - 1]
        left = [0] * length
        right = [0] * length
        
        for i in range(1, length):
            minValue = min(minValue, prices[i])
            left[i] = max(left[i - 1], prices[i] - minValue)
            
        for i in range(length - 1, 0, -1):
            maxValue = max(maxValue, prices[i])
            right[i - 1] = max(right[i], maxValue - prices[i - 1])
            
        res = 0
        for i in range(0, length):
            res = max(res, left[i] + right[i])
        return res
