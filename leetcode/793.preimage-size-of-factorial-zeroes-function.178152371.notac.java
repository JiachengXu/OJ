class Solution {
    public int preimageSizeFZF(int K) {
        int b = K % 6;
        if(b == 5) return 0;
        return 5;
    }
}
