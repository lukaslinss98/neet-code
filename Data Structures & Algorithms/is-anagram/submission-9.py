class Solution:
    def isAnagram(self, s: str, t: str) -> bool:

        if len(s) != len(t):
            return False

        counts_s = {}
        counts_t = {}
        idx = 0

        while idx < len(s):
            counts_s[s[idx]] = counts_s.get(s[idx], 0) + 1
            counts_t[t[idx]] = counts_t.get(t[idx], 0) + 1

            idx += 1

        return counts_s == counts_t

        