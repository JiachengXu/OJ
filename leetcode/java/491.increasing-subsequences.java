class Solution {
  public List<List<Integer>> findSubsequences(int[] nums) {
    List<List<Integer>> resfinal = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    if (nums == null || nums.length == 0)
      return resfinal;
    Set<List<Integer>> res = new HashSet<>();
    backtracking(nums, res, temp, 0);
    return new ArrayList<>(res);
  }

  public void backtracking(int[] nums, Set<List<Integer>> res, List<Integer> temp, int start) {
    if (temp.size() >= 2) {
      res.add(new ArrayList<>(temp));
    }
    for (int i = start; i < nums.length; i++) {
      if (temp.size() == 0 || temp.get(temp.size() - 1) <= nums[i]) {
        temp.add(nums[i]);
        backtracking(nums, res, temp, i + 1);
        temp.remove(temp.size() - 1);
      }
    }
  }
}