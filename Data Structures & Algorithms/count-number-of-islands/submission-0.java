class Solution {
  static record Coord(int r, int c) {}

  public int numIslands(char[][] grid) {
    Set<Coord> visited = new HashSet<>();

    int count = 0;

    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[0].length; c++) {
        int cell = grid[r][c];

        Coord coord = new Coord(r, c);
        if (cell == '0' || visited.contains(coord)) {
          continue;
        }
        count++;
        dfs(grid, r, c, visited);
      }
    }
    return count;
  }

  private static void dfs(char[][] grid, int r, int c, Set<Coord> visited) {
    int ROWS = grid.length;
    int COLS = grid[0].length;

    Coord coord = new Coord(r, c);

    if (Math.min(r, c) < 0
        || r >= ROWS
        || c >= COLS
        || visited.contains(coord)
        || grid[r][c] == '0') {
      return;
    }


    visited.add(coord);
    dfs(grid, r + 1, c, visited);
    dfs(grid, r - 1, c, visited);
    dfs(grid, r, c + 1, visited);
    dfs(grid, r, c - 1, visited);
  }

}
