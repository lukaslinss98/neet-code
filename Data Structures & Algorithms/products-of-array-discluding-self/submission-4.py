class Solution:
    def productExceptSelf(self, nums: list[int]) -> list[int]:
        prefix = [1] * len(nums)
        postfix = [1] * len(nums)

        for i in range(len(nums) - 2, -1, -1):
            postfix[i] = nums[i + 1] * postfix[i + 1]

        for i in range(1, len(nums)):
            prefix[i] = prefix[i - 1] * nums[i - 1]

        res = []

        for idx in range(len(nums)):
            res.append(prefix[idx] * postfix[idx])

        return res
