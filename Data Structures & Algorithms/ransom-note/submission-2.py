class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        char_count = {}
        for c in magazine:
            char_count[c] = char_count.get(c, 0) + 1

        for c in ransomNote:
            count = char_count.get(c, 0)
            if count == 0:
                return False
            char_count[c] = count - 1
        
        return True