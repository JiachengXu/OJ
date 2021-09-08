class Solution {
    public int hammingDistance(int x, int y) {
        int res = 0;
        int step = 31;
        int xor = x ^ y;
        while(step > 0){
            res += xor&1;
            xor >>>= 1;
            step--;
        }
        return res;
    }
}
