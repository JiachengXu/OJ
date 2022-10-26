class Solution {
  public boolean buddyStrings(String A, String B) {
    char first = '\n';
    char second = '\n';
    if (A.length() != B.length())
      return false;
    if (A.equals(B)) {
      int[] map = new int[26];
      for (char c : A.toCharArray()) {
        map[c - 'a']++;
        if (map[c - 'a'] > 1)
          return true;
      }
    }
    List<Integer> dif = new ArrayList<>();
    for (int i = 0; i < A.length(); ++i)
      if (A.charAt(i) != B.charAt(i))
        dif.add(i);
    return dif.size() == 2 && A.charAt(dif.get(0)) == B.charAt(dif.get(1))
        && A.charAt(dif.get(1)) == B.charAt(dif.get(0));
  }
}