class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        heap = []
        for num in arr:
            priority = abs(x - num)
            heapq.heappush(heap, (priority, num))

        res = [0] * k
        while k > 0:
            popped = heapq.heappop(heap)[1]
            res[k-1] = popped
            k -= 1

        return sorted(res)


        