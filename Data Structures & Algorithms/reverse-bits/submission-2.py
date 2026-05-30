class Solution:
    def reverseBits(self, n: int) -> int:
        res = 0
        for _ in range(32):
            if n & 1 == 1:
                res = res << 1
                res = res + 1
            else:
                res = res << 1
        
            n = n >> 1
        return res