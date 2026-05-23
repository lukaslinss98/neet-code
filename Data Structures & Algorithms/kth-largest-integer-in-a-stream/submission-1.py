from heapq import heapify, heappop

class KthLargest:
    def __init__(self, k: int, nums: List[int]):
        self.k = k
        self.heap = nums

    def add(self, val: int) -> int:
        self.heap.append(val)
        heapify(self.heap)
        while len(self.heap) > self.k:
            heappop(self.heap)

        return self.heap[0]
