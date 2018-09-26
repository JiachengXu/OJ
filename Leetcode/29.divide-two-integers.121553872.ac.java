class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0||(dividend==Integer.MIN_VALUE&&divisor == -1)) return Integer.MAX_VALUE; 
        if(dividend==0) return 0;
        int sign = (divisor<0)^(dividend>0)?1:-1;
        long did = Math.abs((long)dividend);
        long div = Math.abs((long)divisor);
        long res = 0;
        while(did>=div){
            long temp = div;
            long count = 1;
            while(did>=(temp<<1)){
                temp<<=1;
                count<<=1;
            }
            did -= temp;
            res += count;
        }
        return sign==1? (int) res:(int)-res;
    }
}
