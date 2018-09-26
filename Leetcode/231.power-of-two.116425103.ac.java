class Solution {
    public boolean isPowerOfTwo(int n) {
        int nums = 0;
        if(n<0)return false;
        for(int i = 0; i < 31; i++){
            if((n&(1<<i))!=0){
                nums++;
            }
        }
        return nums==1;
    }
}
