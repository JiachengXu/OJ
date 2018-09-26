class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int dp1 = 0;
        int dp2 = 0;
        int dp3 = 0;
        int i = 2;
        while(i <= cost.length){
            dp3 = Math.min(dp1 + cost[i - 2], dp2 + cost[i - 1]);
            dp1 = dp2;
            dp2 = dp3;
            i++;
        }
        return dp3;
    }
}
