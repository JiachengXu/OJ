class Solution {
  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    for (int i = 0; i < flowerbed.length; i++) {
      if (flowerbed[i] == 1) {
        continue;
      }
      if (i == 0) {
        if (flowerbed.length == 1) {
          n--;
          flowerbed[i] = 1;
        } else if (flowerbed[1] == 0) {
          n--;
          flowerbed[i] = 1;
        }
      } else if (i == flowerbed.length - 1) {
        if (flowerbed[i - 1] == 0) {
          n--;
          flowerbed[i] = 1;
        }
      } else {
        if (flowerbed[i] == 0 && flowerbed[i + 1] == 0 && flowerbed[i - 1] == 0) {
          n--;
          flowerbed[i] = 1;
        }
      }
    }
    return n <= 0;
  }
}