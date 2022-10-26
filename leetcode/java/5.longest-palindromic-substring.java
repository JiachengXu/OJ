class Solution {
  public String longestPalindrome(String s) {
    int start = 0;
    int end = 0;
    for (int i = 0; i < s.length(); i++) {
      int len1 = getPalindrome(s, i, i);
      int len2 = getPalindrome(s, i, i + 1);
      int len = Math.max(len1, len2);
      if (len > (end - start) + 1) {
        start = i - (len - 1) / 2;
        end = i + len / 2;
      }
    }
    return s.substring(start, end + 1);
  }

  int getPalindrome(String s, int left, int right) {
    int L = left;
    int R = right;
    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
      L--;
      R++;
    }
    return R - L - 1;
  }
}
