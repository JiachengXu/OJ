class Solution {
    public boolean checkPossibility(int[] nums) {
        int res = 0;
        int p = 0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]) {
                res++;
                p = i;
            }
            if(res>1) return false;
        }
        return res==0||(p==0||p==nums.length-2||nums[p-1]<=nums[p+1]||nums[p]<=nums[p+2]);
    }
}