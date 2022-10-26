class Solution {
  public int res = 0;
  public int findTargetSumWays(int[] nums, int S) {
    if (nums == null || nums.length == 0)
      return 0;
    dfs(0, nums, S - nums[0]);
    dfs(0, nums, S + nums[0]);
    return res;
  }
  public void dfs(int idx, int[] nums, int S) {
    if (idx == nums.length - 1) {
      if (S == 0)
        res++;
      return;
    }
    dfs(idx + 1, nums, S - nums[idx + 1]);
    dfs(idx + 1, nums, S + nums[idx + 1]);
  }
}