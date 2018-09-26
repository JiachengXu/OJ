class Solution {
    public int findLongestChain(int[][] pairs) {
        if(pairs==null||pairs.length==0) return 0;
        int len = pairs.length;
        int[] dp = new int[len];
        dp[0] = 1;
        Arrays.sort(pairs,(a,b)->(a[0]-b[0]));
        for(int i=0;i<len;i++){
            for(int j=0;j<i;j++){
                dp[i] = Math.max(dp[i],pairs[i][0]>pairs[j][1]?dp[j]+1:dp[j]);
            }
        }
        return dp[len-1];
    }
}
