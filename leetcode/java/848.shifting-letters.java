class Solution {
    public String shiftingLetters(String S, int[] shifts) {
        if(shifts == null || shifts.length == 0) return S;
        for(int i = shifts.length - 2; i >= 0; i--){
            shifts[i] += shifts[i+1];
            shifts[i] %= 26;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < shifts.length; i++){
            sb.append(shift(S.charAt(i) - 'a', shifts[i]));
        }
        return sb.toString();
    }
    char shift(int c, int num){
        return (char)('a'+ (c + num) % 26);
    }
}