class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        if n <= 0:
            return False
        num = 1
        while num <= 2**32:
            if num == n:
                return True
            num *= 2
        
        return False