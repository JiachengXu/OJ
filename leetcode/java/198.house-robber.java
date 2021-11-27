class Solution {
    public int rob(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int len = nums.length;
        int dp1 = 0;
        int dp2 = 0;
        int dp3 = 0;
        for(int i=0;i<len;i++){
            dp1 = dp2;
            dp2 = dp3;
            dp3 = Math.max(dp1+nums[i],dp2);
        }
        return dp3;
    }
}