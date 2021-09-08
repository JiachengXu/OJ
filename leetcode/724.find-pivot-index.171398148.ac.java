class Solution {
    public int pivotIndex(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        long sum = 0;
        for( int num : nums){
            sum += num;
        }
        long prefix = 0;
        for(int i = 0; i < nums.length; i++){
            if(2 * prefix + nums[i] == sum ){
                return i;
            }
            prefix += nums[i];
        }
        return -1;
    }
}
