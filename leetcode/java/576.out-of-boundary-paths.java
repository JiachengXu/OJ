class Solution {
  public int findPaths(int m, int n, int N, int i, int j) {
    int res = 0;
    int mod = 1000000007;
    int[][] dp = new int[m][n];
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    dp[i][j] = 1;
    for (int l = 0; l < N; l++) {
      int[][] temp = new int[m][n];
      for (int r = 0; r < m; r++) {
        for (int c = 0; c < n; c++) {
          for (int k = 0; k < 4; k++) {
            int ii = r + dx[k];
            int jj = c + dy[k];
            if (ii < 0 || ii >= m || jj < 0 || jj >= n) {
              res = (res + dp[r][c]) % mod;
            } else {
              temp[ii][jj] = (temp[ii][jj] + dp[r][c]) % mod;
            }
          }
        }
      }
      dp = temp;
    }
    return res;
  }
}