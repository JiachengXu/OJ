class MagicDictionary {
  private Trie trie;

  /** Initialize your data structure here. */
  public MagicDictionary() {
    trie = new Trie();
  }

  /** Build a dictionary through a list of words */
  public void buildDict(String[] dict) {
    for (String word : dict) {
      trie.insert(word);
    }
  }

  /**
   * Returns if there is any word in the trie that equals to the given word after modifying exactly
   * one character
   */
  public boolean search(String word) {
    char[] cs = word.toCharArray();
    boolean res = trie.search(word);
    for (int i = 0; i < cs.length; i++) {
      for (char c = 'a'; c <= 'z'; c++) {
        if (cs[i] == c)
          continue;
        char temp = cs[i];
        cs[i] = c;
        if (trie.search(new String(cs)))
          return true;
        cs[i] = temp;
      }
    }
    return false;
  }
  class Trie {
    Node root;
    public Trie() {
      root = new Node();
    }
    public void insert(String word) {
      Node cur = root;
      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        if (cur.children[c - 'a'] == null)
          cur.children[c - 'a'] = new Node();
        cur = cur.children[c - 'a'];
      }
      cur.isWord = true;
    }
    public boolean search(String word) {
      Node cur = root;
      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        if (cur.children[c - 'a'] == null)
          return false;
        cur = cur.children[c - 'a'];
      }
      return cur.isWord;
    }
  }

  class Node {
    boolean isWord;
    Node[] children;
    public Node() {
      children = new Node[26];
    }
  }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */