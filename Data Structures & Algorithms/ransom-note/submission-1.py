class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        char_count = {}
        for c in magazine:
            if c in char_count:
                char_count[c] = char_count[c] + 1
            else:
                char_count[c] = 1

        for c in ransomNote:
            count = char_count.get(c, 0)
            if count == 0:
                return False
            char_count[c] = count - 1
        
        return True