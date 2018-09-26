class Solution {
    public int findLHS(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
            if(map.containsKey(n-1)){
                res = Math.max(res,map.get(n)+map.get(n-1));
            }
            if(map.containsKey(n+1)){
                res = Math.max(res,map.get(n)+map.get(n+1));
            }
        }
        return res;
    }
}
