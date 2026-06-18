class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        char_counts = {}

        for c in s:
            char_counts[c] = char_counts.get(c, 0) + 1
        
        for c in t:
            if c not in char_counts:
                return False
            char_counts[c] = char_counts[c] - 1
            if char_counts[c] == 0:
                del char_counts[c]
        
        return len(char_counts) == 0