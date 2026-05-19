class Solution {
  static record Coord(int r, int c) {}

  public int shortestPathBinaryMatrix(int[][] grid) {
    if(grid[0][0] == 1){
      return -1;
    }

    int ROWS = grid.length;
    int COLS = grid[0].length;
    Queue<Coord> queue = new LinkedList<>();
    Set<Coord> visited = new HashSet<>();

    Coord start = new Coord(0, 0);
    queue.offer(start);
    visited.add(start);

    int length = 1;
    List<Coord> directions =
        List.of(
            new Coord(1, 0),
            new Coord(-1, 0),
            new Coord(0, 1),
            new Coord(0, -1),
            new Coord(1, 1),
            new Coord(-1, -1),
            new Coord(1, -1),
            new Coord(-1, 1));

    while (!queue.isEmpty()) {

        int queueSize = queue.size();
      for (int i = 0; i < queueSize; i++) {
        Coord coord = queue.poll();

        if (coord.r == ROWS - 1 && coord.c == COLS - 1) {
          return length;
        }

        for (Coord direction : directions) {
          Coord neighbor = new Coord(coord.r + direction.r, coord.c + direction.c);

          if (neighbor.r == ROWS
              || neighbor.c == COLS
              || neighbor.r < 0
              || neighbor.c < 0
              || visited.contains(neighbor)
              || grid[neighbor.r][neighbor.c] == 1) {
            continue;
          }

          queue.offer(neighbor);
          visited.add(neighbor);
        }
      }
      length++;
    }
    return -1;
  }

}