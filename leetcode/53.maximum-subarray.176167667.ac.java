class Solution {
    public int maxSubArray(int[] nums) {
        int n  = nums.length;
        int prev= nums[0];
        int max = nums[0];
        int cur = 0;
        for(int i = 1; i < n; i++){
            cur = (prev > 0 ? prev : 0) + nums[i];
            max = Math.max(max, cur);
            prev = cur;
        }
        return max;
    }
}
