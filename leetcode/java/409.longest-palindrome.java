class Solution {
    public int longestPalindrome(String s) {
        if(s==null||s.length()==0) return 0;
        Set<Character> h = new HashSet<>();
        int count = 0;
        for(int i=0; i<s.length();i++){
            char c = s.charAt(i);
            if(h.contains(c)){
                h.remove(c);
                count++;
            }else{
                h.add(c);
            }
        }
        return h.isEmpty()?count*2:count*2+1;
    }
}