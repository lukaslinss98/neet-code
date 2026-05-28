class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:

        map = {n: [] for n in range(0, numCourses)}

        for course, pre_req in prerequisites:
            map[course].append(pre_req)

        print(map)

        memo = {}
        for course in map.keys():
            is_possible = self.dfs(course, map, memo, set([course]))
            if not is_possible:
                return False

        return True

    def dfs(self, course, map, memo, visited):
        if course in memo:
            return memo[course]

        pre_req = map[course]
        if not pre_req:
            memo[course] = True
            return True

        result = False
        for c in pre_req:
            if c in visited:
                result = False
                memo[c] = result
                break
            elif c in memo:
                result = memo[c]
            else:
                visited.add(c)
                result = self.dfs(c, map, memo, visited)
                visited.remove(c)
                memo[c] = result

        return result

