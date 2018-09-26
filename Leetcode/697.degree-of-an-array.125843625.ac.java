class Solution {
    public int findShortestSubArray(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        Map<Integer,Integer> left = new HashMap<>();
        Map<Integer,Integer> right = new HashMap<>();
        Map<Integer,Integer> feq = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(left.get(nums[i])==null) left.put(nums[i],i);
            right.put(nums[i],i);
            feq.put(nums[i],feq.getOrDefault(nums[i],0)+1);
        }
        int degree = Collections.max(feq.values());
        int res = nums.length;
        for(int x:feq.keySet()){
            if(feq.get(x)==degree){
                res = Math.min(res,right.get(x)-left.get(x)+1);
            }
        }
        return res;
        
    }
}
