class Solution {
  private int res = 0;
  public int totalNQueens(int n) {
    boolean[] flagcol = new boolean[n];
    boolean[] flag45 = new boolean[2 * n - 1];
    boolean[] flag135 = new boolean[2 * n - 1];
    helper(flagcol, flag45, flag135, 0, n);
    return res;
  }

  void helper(boolean[] flagcol, boolean[] flag45, boolean[] flag135, int row, int n) {
    if (row == n)
      res++;
    else {
      for (int col = 0; col < n; col++) {
        if (!flagcol[col] && !flag45[col + row] && !flag135[n - 1 - row + col]) {
          flagcol[col] = true;
          flag45[col + row] = true;
          flag135[n - 1 - row + col] = true;
          helper(flagcol, flag45, flag135, row + 1, n);
          flagcol[col] = false;
          flag45[col + row] = false;
          flag135[n - 1 - row + col] = false;
        }
      }
    }
  }
}