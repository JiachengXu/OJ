class Solution {
    public int longestPalindromeSubseq(String s) {
        if(s==null||s.length()==0) return 0;
        int len = s.length();
        int[] dp = new int[len];
        int prev;
        for(int i = len-1; i>=0; i--){
            dp[i] = 1;
            prev = 0;
            for(int j = i+1;j<len;j++){
                int current = dp[j];
                dp[j] = s.charAt(i)==s.charAt(j) ? prev + 2:Math.max(dp[j-1],dp[j]);
                prev = current;
            }
        }
        return dp[len-1];    
    }
}