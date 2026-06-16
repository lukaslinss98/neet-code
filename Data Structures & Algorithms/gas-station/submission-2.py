class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        if sum(cost) > sum(gas):
            return -1


        total = 0
        res = -1
        for i, (gas, cost) in enumerate(zip(gas, cost)):
            diff = gas - cost
            res = i if res == -1 else res
            total += diff
            print(total, res)
            if total < 0:
                res = -1
                total = 0


        return res