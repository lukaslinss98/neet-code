class Solution:
    def findMin(self, nums: List[int]) -> int:
        return self.findMinPtr(nums, 0, len(nums) - 1)

    def findMinPtr(self, nums, lptr, rptr) -> int:
        
        if lptr == rptr:
            return nums[lptr]

        mid = (rptr + lptr) // 2
        left = self.findMinPtr(nums, lptr, mid)
        right = self.findMinPtr(nums, mid + 1, rptr)

        return min(left, right)
