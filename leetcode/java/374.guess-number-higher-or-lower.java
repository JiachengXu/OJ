/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
  public int guessNumber(int n) {
    int l = 1, r = n;
    while (l <= r) {
      int gu = l + (r - l) / 2;
      int temp = guess(gu);
      if (temp == 1)
        l = gu + 1;
      else if (temp == -1)
        r = gu - 1;
      else
        return gu;
    }
    return -1;
  }
}