class Solution {
  int[] dx = {1, 0, -1, 0};
  int[] dy = {0, 1, 0, -1};
  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    if (image == null || image.length == 0 || image[0] == null || image[0].length == 0
        || image[sr][sc] == newColor)
      return image;
    dfs(image, sr, sc, newColor, image[sr][sc]);
    return image;
  }

  public void dfs(int[][] image, int x, int y, int newColor, int oldColor) {
    if (x < 0 || x >= image.length || y < 0 || y >= image[0].length || image[x][y] != oldColor)
      return;
    image[x][y] = newColor;
    for (int i = 0; i < 4; i++) {
      dfs(image, x + dx[i], y + dy[i], newColor, oldColor);
    }
  }
}