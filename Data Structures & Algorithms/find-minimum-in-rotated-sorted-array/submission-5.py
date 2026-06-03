class Solution:
    def findMin(self, nums: List[int]) -> int:
        return self.findMinPtr(nums, 0, len(nums) - 1)

    def findMinPtr(self, nums, lptr, rptr) -> int:
        
        if lptr == rptr:
            return nums[lptr]

        mid = (rptr + lptr) // 2
        
        if nums[mid] > nums[-1]:
            return self.findMinPtr(nums, mid+1, rptr)
        else:
            return self.findMinPtr(nums, lptr, mid)
