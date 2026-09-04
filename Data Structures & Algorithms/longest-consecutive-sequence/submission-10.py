class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        s = set(nums)

        longest = 0
        for n in s:
            if n - 1 not in s:
                seq = 1
                next = n + 1

                while next in s:
                    seq += 1
                    next += 1

                longest = max(longest, seq)

        return longest
