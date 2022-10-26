class Solution {
  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0)
      return 0;
    Map<Character, Integer> map = new HashMap<>();
    int start = 0;
    int res = Integer.MIN_VALUE;
    for (int i = 0; i < s.length(); i++) {
      if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) >= start) {
        start = map.get(s.charAt(i)) + 1;
      }
      map.put(s.charAt(i), i);
      res = Math.max(res, i - start + 1);
    }
    return res;
  }
}