class Solution {
  public int countBinarySubstrings(String s) {
    if (s.length() == 1)
      return 0;
    int res = 0;
    int prevlength = 0;
    int curlength = 0;
    for (int i = 0; i < s.length() - 1; i++) {
      if (s.charAt(i) == s.charAt(i + 1)) {
        curlength++;
      } else {
        prevlength = curlength;
        curlength = 0;
      }
      if (prevlength >= curlength)
        res++;
    }
    return res;
  }
}