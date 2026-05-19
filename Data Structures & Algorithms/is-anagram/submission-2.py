class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if(len(s) != len(t)):
            return False
        
        t_list = list(t)
        for c in s:
            if c not in t_list:
                return False
            else:
                t_list.remove(c)
        
        return True