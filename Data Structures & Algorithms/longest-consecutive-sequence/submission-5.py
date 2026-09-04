class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if len(nums) < 2:
            return len(nums)

        nums =  sorted(set(nums))

        L, R = 0, 0 

        longest = 1
        seq = set()
        while R < len(nums):
            if L == R:
                seq.add(nums[R])
                R += 1
            else:
                if nums[R-1] == nums[R]-1 or nums[R-1] == nums[R]:
                    seq.add(nums[R])
                    longest = max(longest, len(seq))
                    R += 1
                else:
                    seq = set()
                    L=R



        return longest