class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for i, num in enumerate(nums):
            for j, comp in enumerate(nums):
                if i == j:
                    continue
                if num + comp == target:
                    return [i, j]

        return []
        