class Solution {
  public List<String> generateParenthesis(int n) {
    List<String> res = new ArrayList<>();
    backtracking(res, "", 0, 0, n);
    return res;
  }
  void backtracking(List<String> res, String str, int open, int close, int max) {
    if (str.length() == 2 * max) {
      res.add(str);
      return;
    }

    if (open < max) {
      backtracking(res, str + "(", open + 1, close, max);
    }
    if (close < open) {
      backtracking(res, str + ")", open, close + 1, max);
    }
  }
}
