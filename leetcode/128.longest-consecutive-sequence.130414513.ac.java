class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int longnum = 0;
        for(int num : nums){
            int current_length=0;
            if(!set.contains(num-1)){
                int current_num = num;
                current_length = 1;
                while(set.contains(current_num+1)){
                    current_num++;
                    current_length++;
                }
            }
            longnum = Math.max(longnum,current_length);
        }
        return longnum;
    }
}
