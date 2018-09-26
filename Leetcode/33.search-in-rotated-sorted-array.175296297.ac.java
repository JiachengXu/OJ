class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int l = 0, r = nums.length - 1;
        int lv = nums[l], rv = nums[r];
        while(l <= r){
            int mid = l + (r - l) / 2;
            int temp = nums[mid];
            if(target == temp) return mid;
            else if(temp >= lv){
                if( target > temp || target < lv) l = mid + 1;
                else r = mid - 1;
            }else{
                if( target < temp || target > rv) r = mid - 1;
                else l = mid + 1;
            }
        }
        return -1;
    }
}
