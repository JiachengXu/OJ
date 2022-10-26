class Solution {
  public boolean isHappy(int n) {
    int slow = n;
    int fast = n;
    do {
      slow = computeSum(slow);
      fast = computeSum(fast);
      fast = computeSum(fast);
    } while (slow != fast);
    return slow == 1;
  }

  int computeSum(int n) {
    int sum = 0;
    int temp = 0;
    while (n != 0) {
      temp = n % 10;
      sum += temp * temp;
      n /= 10;
    }
    return sum;
  }
}