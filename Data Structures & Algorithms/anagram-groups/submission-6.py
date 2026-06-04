class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagrams = {}
        for s in strs:
            s_sorted = "".join(sorted(s))
            if s_sorted in anagrams:
                anagrams[s_sorted].append(s)
            else:
                anagrams[s_sorted] = [s]

        return [l for l in anagrams.values()]
