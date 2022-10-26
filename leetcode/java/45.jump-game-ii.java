class Solution {
  public int jump(int[] nums) {
    int curfar = 0;
    int curend = 0;
    int res = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      curfar = Math.max(curfar, i + nums[i]);
      if (i == curend) {
        res++;
        curend = curfar;
      }
    }
    return res;
  }
}