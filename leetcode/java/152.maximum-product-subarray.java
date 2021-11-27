class Solution {
    public int maxProduct(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int max = nums[0];
        int min = nums[0];
        int res = max;
        int len = nums.length;
        for(int i=1;i<len;i++){
            if(nums[i]<0){ 
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(max*nums[i],nums[i]);
            min = Math.min(min*nums[i],nums[i]);
            res = Math.max(res,max);
        }
        return res;
    }
}