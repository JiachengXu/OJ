class Solution {
    public int arrayNesting(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int len = nums.length;
        int max = Integer.MAX_VALUE;
        int res = 0;
        for(int i=0; i< len;i++){
            if(nums[i]!=max){
                int count= 1;
                int index = nums[i];
                nums[i] = max;
                while(nums[index]!=max){
                    int temp = nums[index];
                    nums[index] = max;
                    index = temp;
                    count++;
                }
                res = Math.max(res,count);
            }
        }
        return res;
    }
}
