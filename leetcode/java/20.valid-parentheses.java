class Solution {
  public boolean isValid(String s) {
    if (s == null || s.length() == 0)
      return true;
    Stack<Character> st = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(' || c == '[' || c == '{')
        st.push(c);
      switch (c) {
        case ')':
          if (st.isEmpty() || st.pop() != '(')
            return false;
          break;
        case ']':
          if (st.isEmpty() || st.pop() != '[')
            return false;
          break;
        case '}':
          if (st.isEmpty() || st.pop() != '{')
            return false;
          break;
      }
    }
    if (!st.isEmpty())
      return false;
    return true;
  }
}