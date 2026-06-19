class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        maxi = float('-inf')
        curr = 0

        for n in nums:
            curr = max(curr, 0) + n
            maxi = max(maxi, curr)
        
        return maxi
        