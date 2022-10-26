class MyHashSet {
  int bucket = 1000;
  int size = 1001;
  boolean[][] container;

  /** Initialize your data structure here. */
  public MyHashSet() {
    container = new boolean[bucket][];
  }

  private int hash(int key) {
    return key % bucket;
  }
  private int pos(int key) {
    return key / bucket;
  }

  public void add(int key) {
    int hash = hash(key);
    if (container[hash] == null)
      container[hash] = new boolean[size];
    container[hash][pos(key)] = true;
  }

  public void remove(int key) {
    int hash = hash(key);
    if (contains(key))
      container[hash][pos(key)] = false;
  }

  /** Returns true if this set contains the specified element */
  public boolean contains(int key) {
    int hash = hash(key);
    return container[hash] != null && container[hash][pos(key)];
  }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */