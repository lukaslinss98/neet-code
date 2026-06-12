class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        maximum = max(nums)
        s = set(nums)
        for n in range(0, maximum+1):
            if n not in s:
                return n


        return maximum +1