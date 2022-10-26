class Solution {
  public int findKthLargest(int[] nums, int k) {
    if (nums == null || nums.length == 0)
      return 0;
    return quickSelect(nums, 0, nums.length - 1, nums.length - k);
  }
  int quickSelect(int[] nums, int start, int end, int k) {
    int pivot = nums[end];
    int left = start;
    for (int i = start; i < end; i++) {
      if (nums[i] < pivot) {
        swap(nums, left, i);
        left++;
      }
    }
    swap(nums, left, end);
    if (left == k)
      return nums[left];
    else if (left < k)
      return quickSelect(nums, left + 1, end, k);
    else
      return quickSelect(nums, start, left - 1, k);
  }
  void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}