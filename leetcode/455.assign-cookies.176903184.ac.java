class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int res = 0;
        if(g == null || g.length == 0 || s == null || s.length == 0) return res;
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0;
        for(int i = 0; i < g.length; i++){
            if(j < s.length && g[i] <= s[j]){
                res++;
                j++;
            }else{
                while(j < s.length && g[i] > s[j]){
                    j++;
                }
                if(j == s.length) return res;
                else{
                    res++;
                    j++;
                } 
            } 
        }
        return res;
    }
}
