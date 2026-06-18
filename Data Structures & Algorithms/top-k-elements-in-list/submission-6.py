class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        num_counts = {}
        for num in nums:
            num_counts[num] = num_counts.get(num, 0) + 1

        frequencies = [[] for _ in range(len(nums) +1)]

        for num, freq in num_counts.items():
            frequencies[freq].append(num)

        res = []
        for i, frequency in enumerate(frequencies[::-1]):
            for n in frequency:
                res.append(n)
                if len(res) >= k:
                    return res

