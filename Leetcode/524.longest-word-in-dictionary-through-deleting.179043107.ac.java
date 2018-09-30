class Solution {
    public String findLongestWord(String s, List<String> d) {
        String max = "";
        for(String word : d){
            if(isSubsequence(s, word)){
                if(max.length() < word.length() ||( max.length() == word.length() && word.compareTo(max) < 0)) max = word;
            }
        }
        return max;
    }
    boolean isSubsequence(String s, String d){
        int j = 0;
        for(int i = 0; i < s.length()&& j <d.length(); i++){
            if(s.charAt(i) == d.charAt(j)) j++;
        }
        return j == d.length();
    }
}
