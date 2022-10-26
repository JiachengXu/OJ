class Solution {
  public boolean validPalindrome(String s) {
    for (int i = 0; i <= s.length() / 2; i++) {
      int j = s.length() - 1 - i;
      if (s.charAt(i) != s.charAt(j)) {
        return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
      }
    }
    return true;
  }

  public boolean isPalindrome(String s, int l, int r) {
    for (int i = l; i <= l + (r - l) / 2; i++) {
      int j = r + l - i;
      if (s.charAt(i) != s.charAt(j))
        return false;
    }
    return true;
  }
}