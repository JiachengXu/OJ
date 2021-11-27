class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] res = new int[m + n];
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                int temp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = temp + res[p2];
                res[p2] = sum % 10; 
                res[p1] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < res.length; i++){
            if(!(sb.length() == 0 && res[i] == 0))
            sb.append(res[i]);
        }
        return sb.length() == 0 ? "0" : sb.toString();
        
    }
}