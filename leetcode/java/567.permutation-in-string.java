class Solution {
  public boolean checkInclusion(String s1, String s2) {
    if (s1 == null || s1.length() == 0)
      return true;
    if (s2 == null || s2.length() < s1.length())
      return false;
    int[] hashmap1 = new int[26];
    int[] hashmap2 = new int[26];
    for (int i = 0; i < s1.length(); i++) {
      hashmap1[s1.charAt(i) - 'a']++;
      hashmap2[s2.charAt(i) - 'a']++;
    }
    int count = 0;
    for (int i = 0; i < 26; i++) {
      if (hashmap1[i] == hashmap2[i])
        count++;
    }
    if (count == 26)
      return true;
    for (int i = 0; i < s2.length() - s1.length(); i++) {
      if (count == 26)
        return true;
      char l = s2.charAt(i);
      char r = s2.charAt(i + s1.length());
      hashmap2[l - 'a']--;
      if (hashmap2[l - 'a'] == hashmap1[l - 'a']) {
        count++;
      } else if (hashmap2[l - 'a'] == hashmap1[l - 'a'] - 1) {
        count--;
      }
      hashmap2[r - 'a']++;
      if (hashmap2[r - 'a'] == hashmap1[r - 'a']) {
        count++;
      } else if (hashmap2[r - 'a'] == hashmap1[r - 'a'] + 1) {
        count--;
      }
    }
    return count == 26;
  }
}