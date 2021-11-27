class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+2][n+2];
        for(int len=1; len<n;len++){
            for(int i=1;i+len<n+1;i++){
                dp[i][i+len] = Integer.MAX_VALUE;
                for(int k=i;k<len+i+1;k++){   
                    dp[i][i+len] = Math.min(dp[i][i+len],k+Math.max(dp[i][k-1],dp[k+1][i+len]));
                }
            }
        }
        return dp[1][n];
    }
}