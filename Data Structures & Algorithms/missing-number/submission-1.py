class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        nums = sorted(nums)
        idx = 0
        while idx + 1 < len(nums):
            num1 =nums[idx]
            num2 =nums[idx+1]
            if num2 - num1 != 1:
                return num1 +1

            idx += 1 

        return 0 if nums[0] != 0 else nums[-1] +1