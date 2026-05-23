class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        distances = {}
        for point in points:
            x, y = point
            distance = math.sqrt((x**2 + y**2))
            distances[(x, y)] = distance

        new_points = [[x,y] for (x,y), _ in sorted(distances.items(), key=lambda x: x[1] )]

        return new_points[:k] 
        