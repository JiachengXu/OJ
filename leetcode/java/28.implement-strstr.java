class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        char[] hs = haystack.toCharArray();
        char[] nl = needle.toCharArray();
        for(int i = 0; i < hs.length; i++){
            if(isSame(i, hs, nl)){
                return i;
            }
        }
        return -1;
        
    }
    
    public boolean isSame(int index, char[] hs, char[] nl){
        if(index + nl.length > hs.length) return false;
        for(int i = 0; i < nl.length; i++){
            if(hs[index + i] != nl[i]) return false;
        }
        return true;
    }
}