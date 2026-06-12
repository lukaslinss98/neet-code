class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        heap = []
        for num in arr:
            priority = abs(x - num)
            heapq.heappush(heap, (priority, num))

        res = []
        while k > 0:
            res.append(heapq.heappop(heap)[1])
            k -= 1

        return sorted(res)


        