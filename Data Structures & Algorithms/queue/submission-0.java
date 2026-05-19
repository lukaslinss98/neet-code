class Deque {

  private static class Entry {

    public int value;
    public Entry next;
    public Entry prev;

    public Entry(int value) {
      this.value = value;
    }
  }

  private Entry head;
  private Entry tail;

  public Deque() {

  }

  public boolean isEmpty() {
    return head == null && tail == null;
  }

  public void append(int value) {
    Entry newEntry = new Entry(value);
    if (isEmpty()) {
      head = newEntry;
      tail = newEntry;
    } else {
      tail.next = newEntry;
      newEntry.prev = tail;
      tail = tail.next;
    }
  }

  public void appendleft(int value) {
    Entry newEntry = new Entry(value);
    if (isEmpty()) {
      head = newEntry;
      tail = newEntry;
    } else {
      head.prev = newEntry;
      newEntry.next = head;
      head = newEntry;
    }
  }

  public int pop() {
    if (isEmpty()) {
      return -1;
    }
    int value = tail.value;
    if(tail == head){
      tail = null;
      head = null;
    } else {
      tail = tail.prev;
      tail.next = null;
    }
    return value;
  }

  public int popleft() {
    if (isEmpty()) {
      return -1;
    }

    int value = head.value;
    if(head == tail){
      tail = null;
      head = null;
    } else {
      head = head.next;
      head.prev = null;
    }
    return value;
  }
}