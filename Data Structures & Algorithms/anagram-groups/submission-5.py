class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        m = {}
        for s in strs:
            s_str =  ''.join(sorted(s))
            if s_str in m:
                m[s_str] = m[s_str] + [s]
            else: 
                m[s_str] = [s]

        return [v for v in m.values()]