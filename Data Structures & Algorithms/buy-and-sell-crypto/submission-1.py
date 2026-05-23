class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        max_profit = 0
        for i, p1 in enumerate(prices):
            p2 = sorted(prices[i:])[-1]
            if p1 < p2:
                max_profit = max(max_profit, p2 - p1)
            

        return max_profit
