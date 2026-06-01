class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        longest = 0
        if not s:
            return longest

        lptr = 0
        rptr = 1

        occurances = {}

        while lptr < len(s):
            window = s[lptr:rptr]
            last = window[-1]

            if occurances.get(last, 0) == 1:
                first = s[lptr]
                occurances[first] = occurances[first] - 1
                lptr += 1
            else:
                occurances[last] = 1
                longest = max(longest, len(window))
                if rptr < len(s):
                    rptr += 1
                else:
                    lptr += 1

        return longest

