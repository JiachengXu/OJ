class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        if(strs == null || strs.length == 0) return 0;
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i < strs.length; i++){
        int[] counts = new int[2];
            for(int j = 0; j < strs[i].length(); j++){
                if(strs[i].charAt(j) == '0') counts[0]++;
                else counts[1]++;
            }
            for(int k = m; k >= counts[0]; k--){
                for(int l = n; l >= counts[1]; l--){
                    dp[k][l] = Math.max(dp[k][l], dp[k - counts[0]][l - counts[1]] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
