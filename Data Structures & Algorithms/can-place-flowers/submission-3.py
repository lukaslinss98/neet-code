class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        placed = 0
        for i, f in enumerate(flowerbed):
            if f == 1:
                continue
            if (i - 1 < 0 or flowerbed[i-1] == 0) and (i + 1 > len(flowerbed) -1 or flowerbed[i+1] == 0):
                flowerbed[i] = 1
                placed += 1
        
        return placed >= n