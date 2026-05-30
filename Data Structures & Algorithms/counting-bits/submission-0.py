class Solution:
    def countBits(self, n: int) -> List[int]:
        result = []
        for n in range(n+1):
            count = 0
            while n > 0: 
                count = count + 1 if n & 1 == 1 else count
                n = n >> 1
            result.append(count)
        
        return result