class Solution {
  public int mySqrt(int x) {
    if (x == 0)
      return 0;
    int l = 1, r = x;
    while (l <= r) {
      int mid = l + (r - l) / 2;
      if (x / mid >= mid) {
        if (x / (mid + 1) < (mid + 1)) {
          return mid;
        }
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }
    return -1;
  }
}