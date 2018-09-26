class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            n--;
            int carry = n % 26;
            sb.append((char)(carry + 'A'));
            n/=26;
        }
        return sb.reverse().toString();
    }
}
