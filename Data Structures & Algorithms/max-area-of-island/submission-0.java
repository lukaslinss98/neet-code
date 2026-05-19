class Solution {
  static record Coord(int r, int c) {}

  public int maxAreaOfIsland(int[][] grid) {
    Set<Coord> visited = new HashSet<>();

    int max = 0;

    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[0].length; c++) {
        int cell = grid[r][c];

        Coord coord = new Coord(r, c);
        if (cell == 0 || visited.contains(coord)) {
          continue;
        }
        int islandSize = dfs(grid, r, c, visited);
        max = Math.max(max, islandSize);
      }
    }
    return max;
  }

  private static int dfs(int[][] grid, int r, int c, Set<Coord> visited) {
    int ROWS = grid.length;
    int COLS = grid[0].length;

    Coord coord = new Coord(r, c);

    if (Math.min(r, c) < 0
        || r >= ROWS
        || c >= COLS
        || visited.contains(coord)
        || grid[r][c] == 0) {
      return 0;
    }

    int count = 1;

    visited.add(coord);
    count += dfs(grid, r + 1, c, visited);
    count += dfs(grid, r - 1, c, visited);
    count += dfs(grid, r, c + 1, visited);
    count += dfs(grid, r, c - 1, visited);
    return count;
  }

}
