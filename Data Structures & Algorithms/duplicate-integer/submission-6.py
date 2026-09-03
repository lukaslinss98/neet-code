class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        s = set()

        for n in nums:
            len_old = len(s)
            s.add(n)

            if len_old == len(s):
                return True
        
        return False

 