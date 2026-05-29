class Solution {
  static record Coord(int r, int c) {
    public Coord right() {
      return new Coord(this.r + 1, this.c);
    }

    public Coord down() {
      return new Coord(this.r, this.c + 1);
    }
  }

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    return uniquePathsWithObstacles(obstacleGrid, new Coord(0, 0), new HashMap<>());
  }

  private int uniquePathsWithObstacles(int[][] grid, Coord coord, Map<Coord, Integer> memo) {

    if (coord.r == grid.length || coord.c == grid[0].length || grid[coord.r][coord.c] == 1) {
      return 0;
    }

    if (coord.r == grid.length - 1 && coord.c == grid[0].length - 1) {
      return 1;
    }

    if (memo.containsKey(coord)) {
      return memo.get(coord);
    }

    memo.put(
        coord,
        uniquePathsWithObstacles(grid, coord.right(), memo)
            + uniquePathsWithObstacles(grid, coord.down(), memo));
    return memo.get(coord);
  }

}