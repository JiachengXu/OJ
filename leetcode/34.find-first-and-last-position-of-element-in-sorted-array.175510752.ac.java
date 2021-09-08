class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1}; 
        if(nums == null || nums.length == 0) return res;
        int l1 = 0, l2 = 0, r1 = nums.length - 1, r2 = nums.length -1;
        while(l1 < r1){
            int mid = l1 + (r1 - l1) / 2;
            if(nums[mid] > target) r1 = mid - 1;
            else if(nums[mid] < target) l1 = mid + 1;
            else r1 = mid;
        }
        if(r1 < 0 || r1 >= nums.length || nums[r1] != target) return res;
        while(l2  < r2){
            int mid = l2 + (r2 - l2) / 2 + 1;
            if(nums[mid] > target) r2 = mid - 1;
            else if(nums[mid] < target) l2 = mid + 1;
            else l2 = mid;
        }
        if(l2 < 0 || l2 >= nums.length || nums[l2] != target) return res;
        res[0] = r1;
        res[1] = l2;
        return res;
    }
}
