class Graph {

  private static class Node {
    public int val;
    public List<Node> neighbors;

    public Node(int val, List<Node> neighbors) {
      this.val = val;
      this.neighbors = neighbors;
    }

    @Override
    public String toString() {
      return "Node [val=" + val + ", neighbors=" + neighbors + "]";
    }
  }

  private final List<Node> nodes;

  public Graph() {
    this.nodes = new ArrayList<>();
  }

  public void addEdge(int src, int dst) {
    Node source = getNode(src).orElseGet(() -> new Node(src, new ArrayList<>()));
    Node dest = getNode(dst).orElseGet(() -> new Node(dst, new ArrayList<>()));

    source.neighbors.add(dest);
    addNode(source);
    addNode(dest);
  }

  public boolean removeEdge(int src, int dst) {
    if (nodeExists(src) && nodeExists(dst)) {

      Node source = getNode(src).orElseThrow();
      source.neighbors.removeIf(node -> node.val == dst);
      return true;
    }
    return false;
  }

  public boolean hasPath(int src, int dst) {
    Node node = getNode(src).orElseThrow();
    Set<Node> visited = new HashSet<>();
    return dfs(node, dst, visited);
  }

  private static boolean dfs(Node node, int dst, Set<Node> visited) {
    if (node.val == dst) {
      return true;
    }

    visited.add(node);

    for (Node neighbors : node.neighbors) {
      if (visited.contains(neighbors)) {
        continue;
      }

      if (dfs(neighbors, dst, visited)) return true;
    }
    return false;
  }

  private boolean nodeExists(int val) {
    return nodes.stream().anyMatch(node -> node.val == val);
  }

  private Optional<Node> getNode(int val) {
    return nodes.stream().filter(node -> node.val == val).findFirst();
  }

  private void addNode(Node node) {
    if (nodeExists(node.val)) {
      return;
    }
    nodes.add(node);
  }
}
