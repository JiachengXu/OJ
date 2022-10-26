class Solution {
  public String reverseWords(String s) {
    if (s == null || s.length() == 0)
      return s;
    String[] words = s.split(" ");
    StringBuilder res = new StringBuilder();
    StringBuilder temp = new StringBuilder();
    for (String word : words) {
      temp.append(word);
      res.append(temp.reverse());
      res.append(" ");
      temp.setLength(0);
    }
    return res.toString().trim();
  }
}