class Solution {
  public int[][] matrixReshape(int[][] nums, int r, int c) {
    int rown = nums.length;
    int coln = nums[0].length;
    if ((rown == r && coln == c) || (rown * coln != r * c))
      return nums;
    int[][] res = new int[r][c];
    int m = 0;
    int l = 0;
    for (int i = 0; i < rown; i++) {
      for (int j = 0; j < coln; j++) {
        if (l == c) {
          m++;
          l = 0;
        }
        res[m][l] = nums[i][j];
        l++;
      }
    }
    return res;
  }
}