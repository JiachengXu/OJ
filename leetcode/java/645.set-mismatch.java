class Solution {
  public int[] findErrorNums(int[] nums) {
    int dup = -1;
    int miss = -1;
    for (int n : nums) {
      if (nums[Math.abs(n) - 1] < 0) {
        dup = Math.abs(n);
      } else {
        nums[Math.abs(n) - 1] *= -1;
      }
    }
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        miss = i + 1;
      }
    }
    return new int[] {dup, miss};
  }
}