class Solution {
  static record Pair(int r, int c) {}

  public int countPaths(int[][] grid) {
    return dfs(grid, 0, 0, new HashSet<>());
  }

  private static int dfs(int[][] grid, int r, int c, Set<Pair> visited) {
    int ROW = grid.length;
    int COL = grid[0].length;

    Pair pair = new Pair(r, c);
    if (Math.min(r, c) < 0
        || r >= ROW
        || c >= COL
        || visited.contains(pair)
        || grid[r][c] == 1) {
      return 0;
    }

    if (r == ROW - 1 && c == COL - 1) {
      return 1;
    }

    visited.add(pair);

    int count = 0;

    count += dfs(grid, r + 1, c, visited);
    count += dfs(grid, r - 1, c, visited);
    count += dfs(grid, r, c + 1, visited);
    count += dfs(grid, r, c - 1, visited);

    visited.remove(pair);
    return count;
  }

}
