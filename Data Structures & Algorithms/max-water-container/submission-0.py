class Solution:
    def maxArea(self, heights: List[int]) -> int:
        max_area = 0
        lptr = 0
        rptr = len(heights) - 1

        while lptr < rptr:
            width = rptr - lptr
            height = min(heights[lptr], heights[rptr])

            max_area = max(max_area, width * height)

            if heights[lptr] >= heights[rptr]:
                rptr -= 1
            else:
                lptr += 1

        return max_area

        