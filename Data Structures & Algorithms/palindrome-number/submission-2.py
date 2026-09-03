class Solution:
    def isPalindrome(self, x: int) -> bool:
        s = str(x)

        L, R = 0, len(s) -1

        while L < R:
            if s[L] != s[R]:
                return False
            
            L+=1
            R-=1
        
        return True

        