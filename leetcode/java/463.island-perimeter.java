class Solution {
  public int islandPerimeter(int[][] grid) {
    int res = 0;
    if (grid == null || grid.length == 0) {
      return res;
    }
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 1) {
          res += SinglePerimeter(grid, i, j);
        }
      }
    }
    return res;
  }
  int SinglePerimeter(int[][] grid, int i, int j) {
    int res = 0;

    if (i == 0 || grid[i - 1][j] == 0) {
      res++;
    }
    if (i == grid.length - 1 || grid[i + 1][j] == 0) {
      res++;
    }
    if (j == 0 || grid[i][j - 1] == 0) {
      res++;
    }
    if (j == grid[i].length - 1 || grid[i][j + 1] == 0) {
      res++;
    }
    return res;
  }
}