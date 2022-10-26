class Solution {
  int count = 0;
  public int countSubstrings(String s) {
    if (s == null || s.length() == 0)
      return 0;
    for (int i = 0; i < s.length(); i++) {
      helper(s, i, i);
      helper(s, i, i + 1);
    }
    return count;
  }
  void helper(String s, int i, int j) {
    while (j < s.length() && i >= 0 && s.charAt(i) == s.charAt(j)) {
      count++;
      i--;
      j++;
    }
  }
}