class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        min = float('inf')
        res = 0;
        for price in prices:
            if price < min:
                min = price
            res = max(res, price - min)
        return res
