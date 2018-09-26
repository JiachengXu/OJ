class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        char[] as = a.toCharArray();
        char[] bs = b.toCharArray();
        int i = as.length - 1;
        int j = bs.length - 1;
        int carry = 0;
        while(i >= 0 || j >= 0){
            int ii = (i < 0 ? '0' : as[i]) - '0';
            int jj = (j < 0 ? '0' : bs[j]) - '0';
            int sum = ii  + jj + carry;
            int digit = sum % 2;
            carry = sum / 2;
            sb.append(digit == 0?'0':'1');
            i--;
            j--;
        }
        if (carry != 0) sb.append('1');
        return sb.reverse().toString();
    }
}
