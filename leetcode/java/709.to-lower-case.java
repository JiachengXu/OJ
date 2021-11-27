class Solution {
    public String toLowerCase(String str) {
        char[] cs = str.toCharArray();
        for(int i = 0; i < str.length(); i++){
            if(cs[i] >= 'A' && cs[i] <= 'Z') cs[i] = (char)(cs[i] - 'A' + 'a');
        }
        return new String(cs);
    }
}