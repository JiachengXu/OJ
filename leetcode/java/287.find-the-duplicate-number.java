class Solution {
    public int findDuplicate(int[] nums) {
        int l = 1;
        int r = nums.length - 1;
        while(l < r){
            int mid = l + (r - l) / 2;
            int count = 0;
            for(int a : nums){
                if(a <= mid) count ++;
            }
            if(count <= mid) l = mid + 1;
            else r = mid;
        }
        return r;
    }
}