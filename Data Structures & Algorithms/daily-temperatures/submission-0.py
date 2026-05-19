class Solution:

    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        res = []
        
        for i, temp in enumerate(temperatures): 
            days_till_warmer = Solution.find_days_till_warmer(temp, temperatures[i+1:]) 
            res.append(days_till_warmer)


        return res

    @staticmethod
    def find_days_till_warmer(temperatur: int, temperatures: List[int]):
        days_till = 0

        for temp in temperatures:
            days_till = days_till + 1
            if temp > temperatur:
                return days_till
        
        return 0
        