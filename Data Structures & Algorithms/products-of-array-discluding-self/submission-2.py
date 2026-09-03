class Solution:
    def productExceptSelf(self, nums: list[int]) -> list[int]:
        prefix = []
        postfix = []

        for idx, n in enumerate(nums):
            prev = prefix[-1] if prefix else 1
            prefix.append(prev * n)

        for idx, n in enumerate(nums[::-1]):
            prev = postfix[-1] if postfix else 1
            postfix.append(prev * n)
        postfix = postfix[::-1]

        res = []

        for idx, _ in enumerate(nums):
            prefix_sum = prefix[idx - 1] if idx > 0 else 1
            post_fix_sum = postfix[idx + 1] if idx + 1 < len(nums) else 1
            res.append(prefix_sum * post_fix_sum)

        return res

        