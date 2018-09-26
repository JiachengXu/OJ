class Solution {
    public int dominantIndex(int[] nums) {
        int first = -1;
        int second = -1;
        int res = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > first){
                second = first;
                first = nums[i];
                res = i;
            }else if(nums[i] > second){
                second = nums[i];
            }
        }
        return first - 2*second >=0 ? res: -1;
        
    }
}
