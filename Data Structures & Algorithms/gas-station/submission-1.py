class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        if sum(cost) > sum(gas):
            return -1
            
        diff = [gas - cost for (gas, cost) in zip(gas, cost)]

        total = 0
        res = -1
        for i, d in enumerate(diff):
            res = i if res == -1 else res
            total += d
            print(total, res)
            if total < 0:
                res = -1
                total = 0


        return res