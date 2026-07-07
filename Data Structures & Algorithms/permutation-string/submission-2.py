class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s1) > len(s2):
            return False

        frequ_s1 = {}
        for c in s1:
            frequ_s1[c] = frequ_s1.get(c, 0) + 1
        
        window = {}
        for c in s2[:len(s1)]:
            window[c] = window.get(c, 0) + 1
        
        if frequ_s1 == window:
            return True
        
        L, R = 0, len(s1)-1

        while R < len(s2) -1:
            R += 1
            window[s2[R]] = window.get(s2[R], 0) + 1
            window[s2[L]] = window[s2[L]] - 1
            L += 1

            print(window, frequ_s1)
            
            if Counter(window) == Counter(frequ_s1):
                return True


        return False


        