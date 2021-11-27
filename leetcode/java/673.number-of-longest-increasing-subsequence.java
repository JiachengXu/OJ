class Solution {
    public int findNumberOfLIS(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int len = nums.length;
        int[] lens = new int[len];
        int[] count = new int[len];
        int maxlen=0;
        int res = 0;
        for(int i=0;i<len;i++){
            lens[i] = 1;
            count[i] = 1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(lens[i]==lens[j]+1){
                        count[i]+=count[j];
                    }
                    if(lens[i]<lens[j]+1){
                        lens[i] = lens[j]+1;
                        count[i] = count[j];
                    }
                }
            }
            if(maxlen==lens[i]){
                res+=count[i];
            }
            if(maxlen<lens[i]){
                maxlen = lens[i];
                res = count[i];
            }
            
        }
        return res;
    }
}