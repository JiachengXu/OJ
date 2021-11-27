class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> prefix = new HashMap<>();
        int max = 0;
        int sum = 0;
        prefix.put(0 , -1);
        for(int i = 0; i < nums.length; i++){
            sum += (nums[i] == 1? 1 : -1);
            if(prefix.containsKey(sum)){
                max = Math.max(max, i - prefix.get(sum));
            }else{
                prefix.put(sum, i);
            }
        }
        return max;
    }
}