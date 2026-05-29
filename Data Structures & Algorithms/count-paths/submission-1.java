class Solution {
  static record Coord(int r, int c) {}

  public int uniquePaths(int m, int n) {
    return uniquePaths(m, n, 0, 0, new HashMap<>());
  }

  private int uniquePaths(int rows, int cols, int r, int c, Map<Coord, Integer> memo) {

    if (r == rows || c == cols) {
      return 0;
    }

    Coord coord = new Coord(r, c);

    if (memo.containsKey(coord)) {
      return memo.get(coord);
    }

    if (r == rows - 1 && c == cols - 1) {
      return 1;
    }

    memo.put(
        coord, uniquePaths(rows, cols, r + 1, c, memo) + uniquePaths(rows, cols, r, c + 1, memo));

    return memo.get(coord);
  }

}
