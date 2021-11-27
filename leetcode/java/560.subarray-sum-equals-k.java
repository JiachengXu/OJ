class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefix = new HashMap<>();
        int sum = 0;
        int counter = 0;
        prefix.put(0, 1);
        for(int num : nums){
            sum += num;
            if(prefix.containsKey(sum - k)){
                counter += prefix.get(sum-k);
            }
            prefix.put(sum, prefix.getOrDefault(sum, 0) + 1);
        }
        return counter;
    }
}