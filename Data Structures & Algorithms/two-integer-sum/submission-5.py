class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        compliment_index = {}
        for i, num in enumerate(nums):
            if num in compliment_index:
                return [compliment_index[num], i]
            compliment = target - num
            compliment_index[compliment] = i
            
        return []

        