class Solution {
  public double findMaxAverage(int[] nums, int k) {
    if (nums == null | nums.length == 0 || nums.length < k) {
      return 0;
    }
    int sum = 0;
    for (int i = 0; i < k; i++) {
      sum += nums[i];
    }
    int summax = sum;
    for (int i = k; i < nums.length; i++) {
      sum = sum + nums[i] - nums[i - k];
      summax = Math.max(summax, sum);
    }
    return (double) summax / (double) k;
  }
}