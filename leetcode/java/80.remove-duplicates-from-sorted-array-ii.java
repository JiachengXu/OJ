class Solution {
    public int removeDuplicates(int[] nums) {
        int len = 1;
        int count = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                nums[len] = nums[i];
                count = 0;
                len++;
            }else if(nums[i]==nums[i-1]&&count<1){
                nums[len] = nums[i];
                len++;
                count++;
            }
        }
        return len;
    }
}