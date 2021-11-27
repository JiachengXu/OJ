class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins==null||coins.length==0) return -1;
        int[] dp = new int[amount+1];
        int max = amount+1;
        for(int i = 0; i<dp.length;i++){
            dp[i] = max;
        }
        int len = coins.length;
        dp[0] = 0;
        for(int i=1; i<=amount;i++){
            for(int j = 0; j<len;j++){
                if(i - coins[j]>=0) dp[i] = Math.min(dp[i-coins[j]]+1,dp[i]);
            }
        }
        return dp[max-1]>amount?-1:dp[max-1];
    }
}