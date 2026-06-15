class Solution:
    def arrangeCoins(self, n: int) -> int:
        q = -2*n
        k = -(1/2) + math.sqrt((1/2) ** 2 - q)
        return math.floor(k)
        