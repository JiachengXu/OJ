class Solution {
    public int maximumSwap(int num) {
        char[] digit = Integer.toString(num).toCharArray();
        int[] last = new int[10];
        for(int i = 0;i<digit.length;i++){
            last[digit[i]-'0'] = i;
        }
        for(int i = 0; i<digit.length;i++){
            for(int j=9;j>digit[i]-'0';j--){
                if(last[j]>i){
                    char temp = digit[last[j]];
                    digit[last[j]] = digit[i];
                    digit[i] = temp;
                    return Integer.valueOf(new String(digit));
                }
            }
        }
        return num;
        
    }
}