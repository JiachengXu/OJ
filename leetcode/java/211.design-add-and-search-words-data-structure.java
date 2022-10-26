class WordDictionary {
  Node root;

  /** Initialize your data structure here. */
  public WordDictionary() {
    root = new Node();
  }

  /** Adds a word into the data structure. */
  public void addWord(String word) {
    Node cur = root;
    for (char c : word.toCharArray()) {
      if (cur.children[c - 'a'] == null) {
        cur.children[c - 'a'] = new Node();
      }
      cur = cur.children[c - 'a'];
    }
    cur.isWord = true;
  }

  /**
   * Returns if the word is in the data structure. A word could contain the dot character '.' to
   * represent any one letter.
   */
  public boolean search(String word) {
    return match(word.toCharArray(), 0, root);
  }

  boolean match(char[] cs, int k, Node node) {
    if (k == cs.length)
      return node.isWord;
    if (cs[k] != '.') {
      return node.children[cs[k] - 'a'] != null && match(cs, k + 1, node.children[cs[k] - 'a']);
    } else {
      for (int i = 0; i < node.children.length; i++) {
        if (node.children[i] != null) {
          if (match(cs, k + 1, node.children[i])) {
            return true;
          }
        }
      }
      return false;
    }
  }

  class Node {
    boolean isWord;
    Node[] children;
    Node() {
      children = new Node[26];
    }
  }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */