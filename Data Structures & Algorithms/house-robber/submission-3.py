class Solution:
    def rob(self, nums: List[int]) -> int:

        return self.recursion(0, nums, {})

    def recursion(self, idx, nums, memo) -> int:
        if idx >= len(nums):
            return 0

        if idx == len(nums) -1:
            return nums[idx]

        if idx in memo:
            return memo[idx]
        else:
            robbed = nums[idx] + self.recursion(idx +2, nums, memo)
            skipped = self.recursion(idx + 1, nums, memo)
            memo[idx] = max(robbed, skipped)
            return memo[idx]



        