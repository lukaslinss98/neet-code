class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        if not nums:
            return []
    
        res = []
    
        def dfs(nums: List[int], curr):
            if curr is None:
                curr = []
    
            curr_sum = sum(curr) if curr else 0
    
            if curr_sum == target:
                if curr not in res:
                    res.append(curr)
                return

    
            if len(nums) == 0 or curr_sum > target:
                return
    
            dfs(nums[1:].copy(), curr=curr.copy())
    
            curr.append(nums[0])
    
            dfs(nums.copy(), curr=curr.copy())
    
            dfs(nums[1:].copy(), curr=curr.copy())
    
        dfs(nums, curr=[])
    
        return res

    