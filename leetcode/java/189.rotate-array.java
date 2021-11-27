class Solution {
    public void rotate(int[] nums, int k) {
        //Time O(n)
        //Space O(k)
        if(nums == null || nums.length == 0) return; 
        
        k = k % nums.length;
        if(k == 0) return;
        int[] keep = new int[k];
        for(int i= 0; i < k; i++){
            keep[i] = nums[nums.length - k + i];
        }
        
        for(int i = nums.length - k - 1; i >= 0; i--){
           nums[i+k] = nums[i];
        }
        
        for(int i = 0; i < k; i++){
            nums[i] = keep[i];
        }
        
    }
}