class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums = sorted(nums)

        result = []
        for idx, num in enumerate(nums):
            if num > 0:
                break
            if idx > 0 and nums[idx-1] == num:
                continue
                
            L = idx + 1 
            R = len(nums)-1

            while L < R:
                s = num + nums[L] + nums[R]
                if s == 0:
                    result.append([num, nums[L], nums[R]])
                    R-=1
                    L+=1

                    while nums[L] == nums[L-1] and L < R:
                        L+=1

                elif s < 0:
                    L+=1
                else:
                    R-=1
                    

        return result
        
