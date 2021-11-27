class Solution {
    public int rob(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        return Math.max(robLine(nums,0,nums.length-1),robLine(nums,1,nums.length));
    }
    private int robLine(int[] nums, int left, int right){
        int dp1 = 0;
        int dp2 = 0;
        int dp3 = 0;
        for(int i=left;i<right;i++){
            dp1 = dp2;
            dp2 = dp3;
            dp3 = Math.max(dp1+nums[i],dp2);
        }
        return dp3;
    }
}