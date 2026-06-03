class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]

        mid = len(nums) // 2 
        left = self.findMin(nums[:mid])
        right = self.findMin(nums[mid:])

        return min(left, right)
        