class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n == 0 || primes == null || primes.length == 0) return 0;
        int[] ps = new int[primes.length];
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++){
            dp[i] = findmin(ps, primes,dp);
            for(int j = 0; j < primes.length; j++){
                if(dp[i] == dp[ps[j]] * primes[j]) ps[j]++;
            }
        }
        return dp[n - 1];
    }
    
    int findmin(int[] ps, int[] primes, int[] dp){
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < primes.length; i++){
            min = Math.min(min, dp[ps[i]] * primes[i]);
        }
        return min;
    }
}