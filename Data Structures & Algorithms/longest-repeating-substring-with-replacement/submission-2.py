class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        longest = 0
        lptr = 0
        rptr = 0
        char_counts = {}

        while lptr < len(s):
            window_len = rptr - lptr
            max_count = max(char_counts.values()) if char_counts else 0

            if max_count - window_len + k >= 0:
                longest = max(longest, window_len)
                if rptr < len(s):
                    char_counts[s[rptr]] = char_counts.get(s[rptr], 0) + 1
                    rptr += 1
                else:
                    char_counts[s[lptr]] = char_counts[s[lptr]] - 1
                    lptr += 1
            else:
                char_counts[s[lptr]] = char_counts[s[lptr]] - 1
                lptr += 1


        return longest
