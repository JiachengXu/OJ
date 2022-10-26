class Solution {
  public boolean lemonadeChange(int[] bills) {
    if (bills.length == 0)
      return true;
    int[] map = new int[2];
    for (int i = 0; i < bills.length; i++) {
      if (bills[i] == 5)
        map[0]++;
      else if (bills[i] == 10) {
        if (map[0] > 0) {
          map[0]--;
          map[1]++;
        } else {
          return false;
        }
      } else {
        if (map[1] > 0 && map[0] > 0) {
          map[0]--;
          map[1]--;
        } else if (map[0] > 2) {
          map[0] -= 3;
        } else
          return false;
      }
    }
    return true;
  }
}