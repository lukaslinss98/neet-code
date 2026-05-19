class Solution {
  static record Coord(int r, int c) {}

  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    dfs(image, sr, sc, color, image[sr][sc], new HashSet<>());
    return image;
  }

  private static void dfs(
      int[][] image, int sr, int sc, int color, int original, Set<Coord> visited) {

    int ROWS = image.length;
    int COLS = image[0].length;

    Coord coord = new Coord(sr, sc);

    if (Math.min(sr, sc) < 0
        || sr >= ROWS
        || sc >= COLS
        || visited.contains(coord)
        || image[sr][sc] != original) {
      return;
    }

    image[sr][sc] = color;
    visited.add(coord);

    dfs(image, sr - 1, sc, color, original, visited);
    dfs(image, sr + 1, sc, color, original, visited);
    dfs(image, sr, sc - 1, color, original, visited);
    dfs(image, sr, sc + 1, color, original, visited);
  }


}