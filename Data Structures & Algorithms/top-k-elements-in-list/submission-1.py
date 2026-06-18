class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        num_counts = {}
        for num in nums:
            num_counts[num] = num_counts.get(num, 0) + 1
        
        num_counts = dict(sorted(num_counts.items(), key=lambda item: item[1], reverse=True))

        res = []
        print(num_counts)
        for num in num_counts.keys():
            res.append(num)
            k -= 1
            if k == 0:
                break
        
        return res


        