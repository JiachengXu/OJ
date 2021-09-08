class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums==null||nums.length==0) return res;
        int len = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[len];
        dp[0] = 1;
        for(int i=1;i<len;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int maxIndex = 0;
        for(int i = 0;i<len;i++){
            maxIndex = dp[maxIndex]>dp[i]? maxIndex:i;
        }
        int curr=dp[maxIndex];
        int temp = nums[maxIndex];
        for(int i=maxIndex;i>=0;i--){
            if(temp%nums[i]==0&&dp[i]==curr){
                res.add(nums[i]);
                temp = nums[i];
                curr--;
            }
        }
        return res;
    }
}
