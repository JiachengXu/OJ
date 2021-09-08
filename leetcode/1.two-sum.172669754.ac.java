class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> keep = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(keep.containsKey(nums[i])){
                int[] res = new int[2];
                res[0] = keep.get(nums[i]);
                res[1] = i;
                return res;
            }
            keep.put(target - nums[i] ,i);
        }
        return new int[2];
    }
}
