class Solution {
  public boolean wordPattern(String pattern, String str) {
    Map<Character, String> map = new HashMap<>();
    Map<String, Character> map2 = new HashMap<>();
    String[] words = str.split(" ");
    if (words.length != pattern.length())
      return false;
    for (int i = 0; i < pattern.length(); i++) {
      if (map.containsKey(pattern.charAt(i))) {
        String word = map.get(pattern.charAt(i));
        if (!word.equals(words[i]))
          return false;
      } else {
        if (map.containsValue(words[i]))
          return false;
        map.put(pattern.charAt(i), words[i]);
      }
    }
    return true;
  }
}