class MyStack {

  private final List<Integer> array;

  public MyStack() {
    this.array = new LinkedList<>();

  }

  public void push(int x) {
    array.add(x);
  }

  public int pop() {
    return array.removeLast();
  }

  public int top() {
    return array.getLast();
  }

  public boolean empty() {
    return array.isEmpty();
  }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */