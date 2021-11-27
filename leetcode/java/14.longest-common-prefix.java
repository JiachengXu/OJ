class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        StringBuilder pre = new StringBuilder(prefix);
        for(int i = 1; i < strs.length; i++){
            if(pre.length() == 0) return "";
            while(pre.length() > 0){
                int pos = strs[i].indexOf(pre.toString()); 
                if(pos != 0) pre.setLength(pre.length() - 1);
                else break; 
            }
        }
        return pre.toString();
    }
}