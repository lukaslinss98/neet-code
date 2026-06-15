class Solution:
    def arrangeCoins(self, n: int) -> int:
        k = 0
        while n >= k:
            n -= k
            k+=1
            
        return k-1

        