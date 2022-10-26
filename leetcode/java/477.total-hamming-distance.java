class Solution {
  public int totalHammingDistance(int[] nums) {
    if (nums == null || nums.length <= 1)
      return 0;
    int sum = 0;
    int one = 0;
    int zero = 0;
    int res = 1;
    while (res != 0) {
      for (int i = 0; i < nums.length; i++) {
        if ((res & nums[i]) == 0) {
          zero++;
        } else {
          one++;
        }
      }
      sum += zero * one;
      res = res << 1;
      zero = 0;
      one = 0;
    }
    return sum;
  }
}