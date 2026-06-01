class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        longest = 0
        if not s:
            return longest

        lptr = 0
        rptr = 1

        occurances = {}

        while lptr < len(s):
            last = s[rptr -1]

            if occurances.get(last, 0) == 1:
                first = s[lptr]
                occurances[first] = occurances[first] - 1
                lptr += 1
            else:
                occurances[last] = 1
                longest = max(longest, rptr - lptr)
                if rptr < len(s):
                    rptr += 1
                else:
                    lptr += 1

        return longest
