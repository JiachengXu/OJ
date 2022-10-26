class Solution {
  public void rotate(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = i + 1; j < matrix[0].length; j++) {
        swap(matrix, i, j, j, i);
      }
    }
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length / 2; j++) {
        swap(matrix, i, j, i, matrix[0].length - 1 - j);
      }
    }
  }

  void swap(int[][] matrix, int i, int j, int m, int n) {
    int temp = matrix[i][j];
    matrix[i][j] = matrix[m][n];
    matrix[m][n] = temp;
  }
}