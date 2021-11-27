class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int len = nums.length;
        int max = 1;
        int dpprev = 1;
        for(int i=1;i<len;i++){
            if(nums[i]>nums[i-1]){
                dpprev++;
            }else{
                dpprev = 1;
            }
            max = Math.max(max,dpprev);
        }
        return max;
    }
}