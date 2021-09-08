class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if(nums==null||nums.length==0) return 0;
        int res = Integer.MIN_VALUE;
        int left = 0;
        int sum = 0;
        for(int i = 0; i<nums.length; i++){
            sum += nums[i];
            while(sum>=k){
                res = Math.max(res,i-left+1);
                sum -= nums[left];
                left++;
            }
        }
        return res==Integer.MIN_VALUE?0:res;
    }
}
