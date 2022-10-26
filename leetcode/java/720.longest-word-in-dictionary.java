class Solution {
  public String longestWord(String[] words) {
    Node root = new Node();
    for (String word : words) root.insert(word);
    String res = "";
    Stack<Node> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      Node cur = stack.pop();
      for (Node child : cur.children) {
        if (child != null && !child.word.equals("")) {
          stack.push(child);
          if (res.length() < child.word.length()
              || (res.length() == child.word.length() && res.compareTo(child.word) > 0)) {
            res = child.word;
          }
        }
      }
    }
    return res;
  }

  class Node {
    String word;
    Node[] children;
    public Node() {
      children = new Node[26];
      word = "";
    }

    public void insert(String word) {
      Node cur = this;
      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        if (cur.children[c - 'a'] == null) {
          cur.children[c - 'a'] = new Node();
        }
        cur = cur.children[c - 'a'];
      }
      cur.word = word;
    }
  }
}