class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        while(i < nums.length){
            sum += nums[i];
            i++;
            while(sum >= s){
                res = Math.min(res, i - j);
                sum -= nums[j];
                j++;
            }
        }
        return res == Integer.MAX_VALUE?0:res;
    }
}