class WordFilter {
  private Trie trie;
  private Map<String, Integer> map;

  public WordFilter(String[] words) {
    trie = new Trie();
    map = new HashMap<>();
    for (int i = 0; i < words.length; i++) {
      map.put(words[i], i);
      trie.insert(words[i]);
    }
  }

  public int f(String prefix, String suffix) {
    List<String> words = trie.search(prefix);
    if (words.size() == 0)
      return -1;
    for (String word : words) {
      if (word.endsWith(suffix)) {
        return map.get(word);
      }
    }
    return -1;
  }

  class Trie {
    private Node root;
    public Trie() {
      root = new Node();
    }

    public void insert(String word) {
      root.word.addFirst(word);
      Node cur = root;
      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        if (cur.children[c - 'a'] == null)
          cur.children[c - 'a'] = new Node();
        cur = cur.children[c - 'a'];
        cur.word.addFirst(word);
      }
    }
    public List<String> search(String word) {
      Node cur = root;
      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        if (cur.children[c - 'a'] == null)
          return new LinkedList<>();
        cur = cur.children[c - 'a'];
      }
      return cur.word;
    }
    class Node {
      private Node[] children;
      public LinkedList<String> word;
      public Node() {
        children = new Node[26];
        word = new LinkedList<>();
      }
    }
  }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */