class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        num_counts = {}
        for num in nums:
            num_counts[num] = num_counts.get(num, 0) + 1

        frequencies = [[] for _ in range(len(nums) +1)]

        for num, freq in num_counts.items():
            print(freq)
            frequencies[freq].append(num)

        res = []
        print(frequencies)
        for i, frequency in enumerate(frequencies[::-1]):
            if len(res) >= k:
                break

            if frequency:
                res.extend(frequency)

        return res
