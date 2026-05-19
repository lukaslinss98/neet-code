class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        ROWS = len(grid)
        COLS = len(grid[0])
    
        fresh_count, rotten = self.count_oranges(grid)
    
        if not rotten and fresh_count == 0:
            return 0
        if not rotten:
            return -1
    
        queue = deque(rotten)
        visited = set(rotten)
    
        directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        minutes = 0
        while queue:
            length = len(queue)
            old_count = fresh_count
            for _ in range(length):
                (r, c) = queue.popleft()
    
                if grid[r][c] == 1:
                    fresh_count -= 1
                
    
                for dr, dc in directions:
                    (nr, nc) = (r + dr, c + dc)
                    if (
                        nr == ROWS
                        or nc == COLS
                        or nr < 0
                        or nc < 0
                        or (nr, nc) in visited
                        or grid[nr][nc] == 0
                    ):
                        continue

                    queue.append((nr, nc))
                    visited.add((nr, nc))
    
            if old_count != fresh_count:
                minutes += 1

            if fresh_count == 0:
                return minutes

    
        return -1
    
    
    def count_oranges(self, grid):
        rotten = []
        fresh_count = 0
        for r in range(len(grid)):
            for c in range(len(grid[r])):
                cell = grid[r][c]
                if cell == 1:
                    fresh_count += 1
                if cell == 2:
                    rotten.append((r, c))
    
        return fresh_count, rotten

