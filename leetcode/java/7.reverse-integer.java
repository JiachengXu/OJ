class Solution {
  public int reverse(int x) {
    long res = 0;
    long abx = Math.abs(x);
    while (abx > 0) {
      int digit = (int) (abx % 10);
      abx /= 10;
      res *= 10;
      res += digit;
    }
    res = x > 0 ? res : -res;
    if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
      return 0;
    return (int) res;
  }
}