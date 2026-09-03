class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        c = Counter(nums).most_common(k)

        return list(map(lambda x: x[0], c))
