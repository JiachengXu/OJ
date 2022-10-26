class Solution {
  public int maximalSquare(char[][] matrix) {
    if (matrix.length == 0 || matrix[0].length == 0)
      return 0;
    int row = matrix.length;
    int col = matrix[0].length;
    int prev = 0;
    int[] dp = new int[col + 1];
    int maxlen = 0;
    for (int i = 1; i < row + 1; i++) {
      for (int j = 1; j < col + 1; j++) {
        int temp = dp[j];
        if (matrix[i - 1][j - 1] == '1') {
          dp[j] = Math.min(Math.min(dp[j - 1], dp[j]), prev) + 1;
          maxlen = Math.max(maxlen, dp[j]);
        } else {
          dp[j] = 0;
        }
        prev = temp;
      }
    }
    return maxlen * maxlen;
  }
}