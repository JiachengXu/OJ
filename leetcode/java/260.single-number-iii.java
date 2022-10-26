class Solution {
  public int[] singleNumber(int[] nums) {
    int twonums = 0;
    for (int n : nums) {
      twonums ^= n;
    }
    twonums &= -twonums;
    int[] res = new int[2];
    for (int n : nums) {
      if ((n & twonums) == 0) {
        res[0] ^= n;
      } else {
        res[1] ^= n;
      }
    }
    return res;
  }
}