public class MinHeap {

  private List<Integer> heap;

  public MinHeap() {
    ArrayList<Integer> heap = new ArrayList<>();
    heap.add(Integer.MIN_VALUE);

    this.heap = heap;
  }

  public void push(int val) {
    heap.add(val);

    if (heap.size() < 2) {
      return;
    }

    int i = heap.size() - 1;
    while (heap.get(i / 2) > heap.get(i)) {
      Integer temp = heap.get(i);
      heap.set(i, heap.get(i / 2));
      heap.set(i / 2, temp);

      i = i / 2;
    }
  }

  public Integer pop() {
    System.out.println(heap.toString());
    if (heap.size() < 2) {
      return -1;
    }

    int top = heap.get(1);

    if (heap.size() == 2) {
      heap.remove(1);
      return top;
    }

    heap.set(1, heap.getLast());
    heap.removeLast();

    perculateDown(1);

    return top;
  }

  public Integer top() {
    if (heap.size() < 2) {
      return -1;
    }
    return heap.get(1);
  }

  public void heapify(List<Integer> nums) {
    if (!nums.isEmpty()){
      nums.add(nums.getFirst());
      nums.set(0, Integer.MIN_VALUE);
    }
    heap = nums;
    int cur = (heap.size() - 1) / 2;

    while (cur > 0) {
      perculateDown(cur);
      cur--;
    }
  }

  private void perculateDown(int i) {
    while (2 * i < heap.size()) {

      if (2 * i + 1 < heap.size()
          && heap.get(2 * i) > heap.get(2 * i + 1)
          && heap.get(2 * i + 1) < heap.get(i)) {

        Integer temp = heap.get(i);
        heap.set(i, heap.get(2 * i + 1));
        heap.set(2 * i + 1, temp);
        i = 2 * i + 1;

      } else if (heap.get(2 * i) < heap.get(i)) {
        Integer temp = heap.get(i);
        heap.set(i, heap.get(2 * i));
        heap.set(2 * i, temp);
        i = 2 * i;
      } else {
        break;
      }
    }
  }

}
