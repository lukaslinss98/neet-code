class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        if not nums:
            return []
    
        res = []
    
        def dfs(nums: List[int], curr, total=0):
            if total == target:
                res.append(curr.copy())
                return
                
    
            if len(nums) == 0 or total > target:
                return
    
            dfs(nums[1:], curr=curr, total=total)

            curr.append(nums[0])

            total += nums[0]
    
            dfs(nums, curr=curr, total=total)

            curr.pop()

    
    
        dfs(nums, curr=[])
    
        return res

    