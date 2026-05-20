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
    if (!nodeExists(src) && !nodeExists(dst)) {
      ArrayList<Node> neighbors = new ArrayList<>();
      Node dest = new Node(dst, new ArrayList<>());
      neighbors.add(dest);

      Node newNode = new Node(src, neighbors);

      nodes.add(newNode);
      nodes.add(dest);
      return;
    } else if (!nodeExists(src)) {
      Node dest = getNode(dst);
      ArrayList<Node> neighbors = new ArrayList<>();
      neighbors.add(dest);

      Node newNode = new Node(src, neighbors);
      nodes.add(newNode);
      return;
    } else if (!nodeExists(dst)) {

      Node source = getNode(src);
      Node dest = new Node(dst, new ArrayList<>());
      nodes.add(dest);

      source.neighbors.add(dest);
      return;
    } else {
      Node source = getNode(src);
      Node dest = getNode(dst);
      source.neighbors.add(dest);
    }
  }


  public boolean removeEdge(int src, int dst) {
    if (nodeExists(src) && nodeExists(dst)) {

      Node source = getNode(src);
      source.neighbors.removeIf(node -> node.val == dst);
      return true;
    }
    return false;
  }

  public boolean hasPath(int src, int dst) {
    Node node = getNode(src);
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

  private Node getNode(int val) {
    return nodes.stream().filter(node -> node.val == val).findFirst().orElseThrow();
  }
}

