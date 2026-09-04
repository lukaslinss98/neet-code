class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = re.sub(r'[^a-zA-Z0-9]', '', s).lower()

        L, R = 0, len(s) - 1

        while L < R:
            if s[L] != s[R]:
                return False
            L += 1
            R -= 1

        return True
