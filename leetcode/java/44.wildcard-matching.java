class Solution {
  public boolean isMatch(String s, String p) {
    int i = 0, j = 0, match = 0, staridx = -1;
    while (i < s.length()) {
      if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
        i++;
        j++;
      } else if (j < p.length() && p.charAt(j) == '*') {
        staridx = j;
        j++;
        match = i;
      } else if (staridx != -1) {
        j = staridx + 1;
        match++;
        i = match;
      } else
        return false;
    }
    while (j < p.length() && p.charAt(j) == '*') j++;
    return j == p.length();
  }
}