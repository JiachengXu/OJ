class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s == null || s.length() == 0) return true;
        int[] cs1 = new int[128];
        int[] cs2 = new int[128];
        for(int i = 0; i < s.length(); i++){
            if(cs1[s.charAt(i)] != cs2[t.charAt(i)]) return false;
            cs1[s.charAt(i)] = i + 1;
            cs2[t.charAt(i)] = i + 1;
        }
        return true;
    }
}
