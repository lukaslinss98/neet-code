class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:

        complement_idx = {}
        for idx, num in enumerate(nums):
            if num in complement_idx:
                return [complement_idx[num], idx]

            complement_idx[target - num] = idx

        return [-1, -1]
