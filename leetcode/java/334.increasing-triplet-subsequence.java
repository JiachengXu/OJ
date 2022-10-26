class Solution {
  public boolean increasingTriplet(int[] nums) {
    int small = Integer.MAX_VALUE;
    int mid = Integer.MAX_VALUE;
    for (int n : nums) {
      if (n <= small) {
        small = n;
      } else if (n <= mid) {
        mid = n;
      } else {
        return true;
      }
    }
    return false;
  }
}