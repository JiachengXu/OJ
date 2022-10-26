class Solution {
  public void sortColors(int[] nums) {
    if (nums == null || nums.length < 2)
      return;
    int rednum = 0;
    int whitenum = 0;
    int bluenum = 0;
    for (int num : nums) {
      if (num == 0) {
        rednum++;
      } else if (num == 1) {
        whitenum++;
      } else if (num == 2) {
        bluenum++;
      }
    }
    for (int i = 0; i < rednum; i++) {
      nums[i] = 0;
    }
    for (int i = rednum; i < rednum + whitenum; i++) {
      nums[i] = 1;
    }

    for (int i = rednum + whitenum; i < rednum + whitenum + bluenum; i++) {
      nums[i] = 2;
    }
  }
}