class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length == 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                int temp = map.get(nums[i]);
                if(i - temp <= k) return true;
                map.put(nums[i], i);
            }else{
                map.put(nums[i], i);
            }
        }
        return false;
    }
}