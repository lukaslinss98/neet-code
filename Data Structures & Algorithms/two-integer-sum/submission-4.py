class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        m = {}
        for i, num in enumerate(nums):
            p = target - num
            if p in m:
                return [m[p], i]
            else:
                m[num] = i

        return []
