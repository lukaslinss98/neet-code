class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        L, R = 0, len(s1)-1
        s1 = ''.join(sorted(s1))

        while R < len(s2):
            window = s2[L:R+1]
            window = ''.join(sorted(window))
            if s1 == window:
                return True
        
            L += 1
            R += 1

        return False
        