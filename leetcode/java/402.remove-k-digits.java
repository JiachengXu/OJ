class Solution {
  public String removeKdigits(String num, int k) {
    Stack<Character> st = new Stack<>();
    if (num == null || num.length() == 0)
      return num;
    if (num.length() == k)
      return "0";
    int len = num.length();
    for (int i = 0; i < len; i++) {
      if (i == 0) {
        st.push(num.charAt(i));
      } else {
        while (k > 0 && !st.isEmpty() && st.peek() > num.charAt(i)) {
          st.pop();
          k--;
        }
        st.push(num.charAt(i));
      }
    }
    while (k > 0) {
      st.pop();
      k--;
    }
    StringBuilder sb = new StringBuilder();
    while (!st.isEmpty()) {
      sb.append(st.pop());
    }
    sb.reverse();
    while (sb.length() > 1 && sb.charAt(0) == '0') {
      sb.deleteCharAt(0);
    }
    return sb.toString();
  }
}