class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        MAX = float('inf')
        res = [0] + [MAX] * amount
        
        for i in range(1, amount + 1):
	    # list comprehension + conditional expresion, syntax: x if C else y
            res[i] = min([res[i - c] if i >= c else MAX for c in coins]) + 1
        
        return -1 if res[amount] == MAX else res[amount]
