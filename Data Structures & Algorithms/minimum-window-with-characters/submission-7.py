class Solution:
    def minWindow(self, s: str, t: str) -> str:
        lptr, rptr = 0, 0
        have_map = {}
        need_map = {}

        for c in t:
            need_map[c] = need_map.get(c, 0) + 1
            if c not in have_map:
                have_map[c] = 0
        have = 0
        need = len(need_map)

        smallest = float("inf")
        res = ""

        while lptr <= len(s):
            if have >= need:
                if rptr - lptr < smallest:
                    smallest = rptr - lptr
                    res = s[lptr : rptr]

                c = s[lptr]
                if c in have_map:
                    have_map[c] = have_map[c] - 1
                    if have_map[c] < need_map[c]:
                        have -= 1
                lptr += 1
            else:
                if rptr == len(s):
                    break

                rptr = rptr + 1
                c = s[rptr-1]
                if c in need_map:
                    have_map[c] = have_map[c] + 1
                    if have_map[c] == need_map[c]:
                        have += 1

        return res
