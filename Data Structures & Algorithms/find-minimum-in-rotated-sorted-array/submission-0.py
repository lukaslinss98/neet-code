class Solution:
    def findMin(self, nums: List[int]) -> int:
        res = float('inf')
        for n in nums:
            res = min(res, n) 

        return res
        