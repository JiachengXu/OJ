class Solution {
    public String licenseKeyFormatting(String S, int K) {
        S = S.toUpperCase();
        StringBuilder sb =new StringBuilder();
        int counter = 0;
        for(int i = S.length() - 1; i >= 0; i--){
            char c = S.charAt(i);
            if(c != '-'){
                counter++;
                sb.append(c);
                if(counter % K == 0) sb.append('-');
            }
        }
        if(sb.length() != 0 && sb.charAt(sb.length() - 1) == '-') sb.setLength(sb.length() - 1);
        return sb.reverse().toString();
    }
}
