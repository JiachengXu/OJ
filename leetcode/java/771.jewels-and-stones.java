class Solution {
    public int numJewelsInStones(String J, String S) {
        int[] map = new int[60];
        if(J == null || J.length() == 0 || S == null || S.length() == 0) return 0;
        for(char c : J.toCharArray()){
            map[c - 'A'] = 1;
        }
        int res = 0;
        for(char c : S.toCharArray()){
            if(map[c - 'A'] == 1){
                res++;
            }
        }
        return res;
    }
}