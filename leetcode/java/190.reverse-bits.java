public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        int step = 31;
        while(step >= 0){
            int temp = n&1;
            res += temp;
            if(step != 0) res <<= 1;
            n >>= 1;
            step --;
        }
        return res;
    }
}