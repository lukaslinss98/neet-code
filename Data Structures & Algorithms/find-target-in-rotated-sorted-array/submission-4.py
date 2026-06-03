class Solution:
    def search(self, nums: List[int], target: int) -> int:
        return self.binary_search(nums, target, 0, len(nums) -1)
        
    def binary_search(self, nums,target, lptr, rptr):
        if lptr == rptr:
            print(lptr)
            return lptr if nums[lptr] == target else -1
        
        mid = (rptr + lptr) // 2

        if nums[mid] == target:
            return mid

        print(lptr, rptr, mid)
        is_left_sorted = nums[mid] >= nums[lptr]

        if is_left_sorted:
            if target >= nums[lptr] and target < nums[mid]:
                return self.binary_search(nums,target, lptr, mid)
            else:
                return self.binary_search(nums,target, mid+1, rptr)
        else:
            if target > nums[mid] and target <= nums[rptr]:
                return self.binary_search(nums,target, mid+1, rptr)
            else:
                return self.binary_search(nums,target, lptr, mid)

        

