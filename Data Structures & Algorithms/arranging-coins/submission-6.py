class Solution:
    def arrangeCoins(self, n: int) -> int:
        q = -2*n
        p = 1
        k = -(p/2) + math.sqrt((p/2) ** 2 - q)
        return int(k)
        