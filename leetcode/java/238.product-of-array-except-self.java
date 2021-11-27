class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[nums.length];
        res[0] = 1;
        for(int i=1; i<len; i++){
            res[i] = res[i-1]*nums[i-1];
        }
        int temp = 1;
        for(int j = len-1;j>=0;j--){
            res[j] = res[j]*temp;
            temp*=nums[j];
        }
        return res;
    }
}