class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) <= 2:
            return max(nums)
            
        return self.recursion(0, nums, {})

    def recursion(self, idx, nums, memo) -> int:
        if idx >= len(nums) -2:
            return nums[idx]

        if idx in memo:
            return memo[idx]
        else:
            robbed = nums[idx] + self.recursion(idx +2, nums, memo)
            skipped = self.recursion(idx + 1, nums, memo)
            memo[idx] = max(robbed, skipped)
            return memo[idx]



        