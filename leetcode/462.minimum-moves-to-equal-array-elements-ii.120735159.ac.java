class Solution {
    public int minMoves2(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        Arrays.sort(nums);
        int n = nums[(nums.length-1)/2];
        int sum = 0;
        for(int m: nums){
            sum+= Math.abs(n-m);
        }
        return sum;
    }
}
