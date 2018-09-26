class Solution {
    public int splitArray(int[] nums, int m) {
        int max = 0; 
        long sum = 0;
        for(int num : nums){
            max = Math.max(max, num);
            sum += num;
        }
        if(nums.length == 1) return (int)sum;
        long l = max, r = sum;
        while(l < r){
            long mid = l + (r - l) / 2;
            if(valid(mid, nums, m)) l =(int) mid + 1;
            else r =(int) mid;
        }
        return (int)r;
    }
    
    boolean valid(long target, int[] nums, int m){
        int sum = 0;
        int counter = 0;
        for(int num : nums){
            sum += num;
            if(sum > target){
                counter++;
                sum = num;
                if(counter >= m) return true;
            }
        }
        return false;
    }
}
