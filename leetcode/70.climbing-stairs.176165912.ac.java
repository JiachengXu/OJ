class Solution {
    public int climbStairs(int n) {
        int i = 1;
        int j = 2;
        if(n == 1) return i;
        if(n == 2) return j;
        int res = 0;
        while(n > 2){
            res = i + j;
            i = j;
            j = res;
            n--;
        }
        return res;
    }
}
