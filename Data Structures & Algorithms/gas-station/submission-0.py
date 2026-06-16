class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        num_stations = len(gas)
        for station in range(num_stations):
            curr = station
            curr_gas = 0
            while True:
                print(curr)
                curr_gas += gas[curr]

                if curr_gas < cost[curr]:
                    break
                
                curr_gas -= cost[curr]
                
                curr = (curr + 1) % num_stations

                if curr == station:
                    return station
                
        return -1