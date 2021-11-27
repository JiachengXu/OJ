class Solution {
    public String customSortString(String S, String T) {
        if(S.length() == 0) return T;
        int[] map = new int[26];
        for(char c : T.toCharArray()){
            map[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(char c : S.toCharArray()){
            if(map[c - 'a'] != 0){
                for(int i =0 ; i < map[c - 'a'];i++) sb.append(c);
            }
            map[c - 'a'] = 0;
        }
        for(int i = 0; i < map.length; i++){
            if(map[i] != 0){
                for(int j =0 ; j < map[i];j++) sb.append((char)(i + 'a'));
            }
            map[i] = 0;
        }
        return sb.toString();
    }
}