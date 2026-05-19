class Solution:
    def isPalindrome(self, s: str) -> bool:
        string = ''.join(ch for ch in s if ch.isalnum())
        l, r = 0, len(string) -1
        while l < r:
            print(l, r)
            if string[l].lower() != string[r].lower():
                return False
            l = l + 1
            r = r - 1

        return True