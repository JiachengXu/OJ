class Solution {
  public double knightProbability(int N, int K, int r, int c) {
    double[][] dp = new double[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        dp[i][j] = 1;
      }
    }
    int[] dx = {1, -1, 1, -1, 2, -2, -2, 2};
    int[] dy = {2, -2, -2, 2, 1, -1, 1, -1};
    for (int i = 0; i < K; i++) {
      double[][] temp = new double[N][N];
      for (int x = 0; x < N; x++) {
        for (int y = 0; y < N; y++) {
          for (int k = 0; k < 8; k++) {
            int rr = x + dx[k];
            int cc = y + dy[k];
            if (rr < 0 || rr >= N || cc < 0 || cc >= N) {
              continue;
            } else {
              temp[x][y] += dp[rr][cc];
            }
          }
        }
      }
      dp = temp;
    }
    System.out.println(dp[r][c]);
    return dp[r][c] / Math.pow(8, K);
  }
}