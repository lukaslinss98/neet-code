public class HashTable {

  static class Pair {
    public int key;
    public int value;
    public Pair next;

    public Pair(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  private Pair[] map;
  private int maxCap;
  private int currCap;

  public HashTable(int capacity) {
    this.map = new Pair[capacity];
    this.maxCap = capacity;
    this.currCap = 0;
  }

  public void insert(int key, int value) {
    int hash = hash(key);

    Pair pair = map[hash];

    if (pair == null) {
      map[hash] = new Pair(key, value);
    } else {
      Pair prev = null;
      while (pair != null) {
        if (pair.key == key) {
          pair.value = value;
          return;
        }
        prev = pair;
        pair = pair.next;
      }
      prev.next = new Pair(key, value);
    }
    currCap++;

    if ((float) currCap / (float) maxCap >= 0.5) {
      resize();
    }
  }


  public int get(int key) {
    int hash = hash(key);
    Pair pair = map[hash];

    if (pair == null) {
      return -1;
    }

    while (pair != null) {
      if (pair.key == key) {
        return pair.value;
      }
      pair = pair.next;
    }

    return -1;
  }

  public boolean remove(int key) {
    int hash = hash(key);
    Pair pair = map[hash];

    if (pair == null) {
      return false;
    }

    if (pair.key == key) {
      map[hash] = pair.next;
      currCap--;
      return true;
    }

    Pair prev = pair;
    Pair curr = pair.next;
    while (curr != null) {
      if (curr.key == key) {
        prev.next = curr.next;
        currCap--;
        return true;
      }
      prev = curr;
      curr = curr.next;
    }

    return false;
  }


  public int getSize() {
    int count = 0;
    for (int i = 0; i < map.length; i++) {
      Pair pair = map[i];
      while (pair != null) {
        count++;
        pair = pair.next;
      }
    }
    return count;
  }

  public int getCapacity() {
    return maxCap;
  }

  public void resize() {
    this.maxCap *= 2;
    this.currCap = 0;

    Pair[] old = map.clone();
    map = new Pair[maxCap];

    for (int i = 0; i < old.length; i++) {
      Pair pair = old[i];
      while (pair != null) {
        insert(pair.key, pair.value);
        pair = pair.next;
      }
    }
  }

  private int hash(int key) {
    return key % maxCap;
  }
}
