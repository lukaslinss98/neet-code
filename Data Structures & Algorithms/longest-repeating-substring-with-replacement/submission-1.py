class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        longest = 0
        lptr = 0
        rptr = 1
        char_counts = {}
        char_counts[s[0]] = 1

        while lptr < len(s):
            print(s[lptr:rptr])
            window_len = rptr - lptr
            max_count = max(char_counts.values())

            if max_count - window_len + k >= 0:
                longest = max(longest, window_len)
                if rptr < len(s):
                    rptr += 1
                    char_counts[s[rptr -1]] = char_counts.get(s[rptr-1], 0) + 1
                else:
                    char_counts[s[lptr]] = char_counts[s[lptr]] - 1
                    lptr += 1
            else:
                char_counts[s[lptr]] = char_counts[s[lptr]] - 1
                lptr += 1


        return longest
