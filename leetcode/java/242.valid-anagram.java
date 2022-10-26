class Solution {
  public boolean isAnagram(String s, String t) {
    int[] counter = new int[256];
    for (char c : s.toCharArray()) {
      counter[c - 'a']++;
    }
    for (char c : t.toCharArray()) {
      counter[c - 'a']--;
      if (counter[c - 'a'] < 0)
        return false;
    }
    for (int c : counter) {
      if (c != 0)
        return false;
    }
    return true;
  }
}