class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int len1 = num1.length();
        int len2 = num2.length();
        int carry = 0;
        for(int i=len1-1,j=len2-1;i>=0||j>=0||carry==1;i--,j--){
            int x = i<0 ? 0 : num1.charAt(i)-'0';
            int y = j<0 ? 0 : num2.charAt(j)-'0';
            int res = x+y+carry;
            sb.append(res%10);
            carry = res/10;
        }
        return sb.reverse().toString();
    }
}
