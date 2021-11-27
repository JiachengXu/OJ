class Solution {
    public double myPow(double x, int n) {
        long absN = Math.abs((long)n);
        double res = helper(x, absN);
        return n < 0 ? 1 / res : res;
    }
    double helper(double x, long n){
        if(n == 0) return 1;
        else if(n == 1) return x;
        double pow = helper(x, n / 2);
        return n % 2 == 0 ?pow * pow : x * pow * pow;
    }
}