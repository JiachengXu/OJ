class Solution {
  public boolean isPalindrome(String s) {
    if (s == null || s.length() == 0)
      return true;
    int l = 0;
    int r = s.length() - 1;
    char ll;
    char rr;
    while (l < r) {
      ll = s.charAt(l);
      rr = s.charAt(r);
      if (!Character.isLetterOrDigit(ll)) {
        l++;
      } else if (!Character.isLetterOrDigit(rr)) {
        r--;
      } else {
        if (Character.toLowerCase(ll) != Character.toLowerCase(rr)) {
          return false;
        }
        l++;
        r--;
      }
    }
    return true;
  }
}