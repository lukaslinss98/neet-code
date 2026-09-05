class Solution:
    def trap(self, height: List[int]) -> int:
        if len(height) <= 2:
            return 0

        prefix = [0] * len(height)
        prefix_max = 0
        for idx in range(len(height)-1, -1, -1):
            prefix_max = max(prefix_max, height[idx])
            if idx == len(height) -1:
                continue
            prefix[idx] = prefix_max
            

        postfix = [0] * len(height)
        postfix_max = 0
        for idx, h in enumerate(height):
            postfix_max = max(postfix_max, h)
            if idx == 0:
                continue
            postfix[idx] = postfix_max
            
        total = 0
        for idx, h in enumerate(height):
            if idx == 0 or idx == len(height) - 1:
                continue

            smaller = min(prefix[idx], postfix[idx])

            if smaller <= h:
                continue

            total += smaller - h

        return total

        