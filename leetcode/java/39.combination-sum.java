class Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> tmp = new ArrayList();
    backtracking(res, tmp, candidates, target, 0);
    return res;
  }

  void backtracking(List<List<Integer>> res, List<Integer> tmp, int[] nums, int target, int start) {
    if (target < 0) {
      return;
    } else if (target == 0) {
      res.add(new ArrayList<>(tmp));
    } else {
      for (int i = start; i < nums.length; i++) {
        tmp.add(nums[i]);
        backtracking(res, tmp, nums, target - nums[i], i);
        tmp.remove(tmp.size() - 1);
      }
    }
  }
}
