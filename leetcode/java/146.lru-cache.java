class LRUCache {
  private Map<Integer, Node> map;
  private Node head;
  private Node tail;
  private int count;
  private int capacity;

  class Node {
    Node prev;
    Node next;
    int value;
    int key;
    public Node(int key, int value) {
      this.value = value;
      this.key = key;
    }
  }

  public LRUCache(int capacity) {
    this.count = 0;
    this.capacity = capacity;
    this.map = new HashMap<>();
    this.head = new Node(0, 0);
    this.tail = new Node(0, 0);
    head.prev = null;
    head.next = tail;
    tail.prev = head;
    tail.next = null;
  }

  private void removeNode(Node node) {
    Node prev = node.prev;
    Node next = node.next;
    prev.next = next;
    next.prev = prev;
  }

  private void addNode(Node node) {
    Node next = head.next;
    head.next = node;
    node.prev = head;
    node.next = next;
    next.prev = node;
  }

  private void moveToHead(Node node) {
    this.removeNode(node);
    this.addNode(node);
  }

  private Node removeTail() {
    Node tail = this.tail.prev;
    this.removeNode(tail);
    return tail;
  }

  public int get(int key) {
    if (!map.containsKey(key))
      return -1;
    Node node = map.get(key);
    this.moveToHead(node);
    return node.value;
  }

  public void put(int key, int value) {
    if (!map.containsKey(key)) {
      Node node = new Node(key, value);
      this.addNode(node);
      map.put(key, node);
      count++;
      if (count > capacity) {
        Node tail = this.removeTail();
        map.remove(tail.key);
        count--;
      }
    } else {
      Node node = map.get(key);
      node.value = value;
      this.moveToHead(node);
    }
  }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */