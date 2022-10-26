class Solution {
  public List<List<Integer>> palindromePairs(String[] words) {
    List<List<Integer>> res = new ArrayList<>();
    Node root = new Node();
    for (int i = 0; i < words.length; i++) {
      insertWord(root, words[i], i);
    }
    for (int i = 0; i < words.length; i++) {
      search(root, words, i, res);
    }
    return res;
  }

  void insertWord(Node root, String word, int index) {
    Node cur = root;
    for (int i = word.length() - 1; i >= 0; i--) {
      int idx = word.charAt(i) - 'a';
      if (cur.children[idx] == null) {
        cur.children[idx] = new Node();
      }
      if (isPalindrome(word, 0, i))
        cur.list.add(index);
      cur = cur.children[idx];
    }
    cur.list.add(index);
    cur.index = index;
  }

  void search(Node root, String[] words, int i, List<List<Integer>> res) {
    Node cur = root;
    for (int j = 0; j < words[i].length(); j++) {
      if (cur.index >= 0 && cur.index != i && isPalindrome(words[i], j, words[i].length() - 1)) {
        res.add(Arrays.asList(i, cur.index));
      }
      cur = cur.children[words[i].charAt(j) - 'a'];
      if (cur == null)
        return;
    }

    for (int j : cur.list) {
      if (i == j)
        continue;
      res.add(Arrays.asList(i, j));
    }
  }

  boolean isPalindrome(String word, int i, int j) {
    while (i < j) {
      if (word.charAt(i) != word.charAt(j))
        return false;
      i++;
      j--;
    }
    return true;
  }
  class Node {
    int index;
    Node[] children;
    List<Integer> list;
    Node() {
      children = new Node[26];
      index = -1;
      list = new ArrayList<>();
    }
  }
}