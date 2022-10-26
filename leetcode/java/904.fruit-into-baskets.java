class Solution {
  public int totalFruit(int[] tree) {
    int max = 0;
    int a = -1;
    int b = -1;
    int countb = 0;
    int count = 0;
    for (int c : tree) {
      if (c == b) {
        count++;
        countb++;
      } else if (c == a) {
        count++;
        countb = 1;
        a = b;
        b = c;
      } else {
        count = countb + 1;
        countb = 1;
        a = b;
        b = c;
      }
      max = Math.max(max, count);
    }
    return max;
  }
}