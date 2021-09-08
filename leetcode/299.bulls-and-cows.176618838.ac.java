class Solution {
    public String getHint(String secret, String guess) {
        int[] contain = new int[10];
        boolean[] mark = new boolean[guess.length()];
        for(char c : secret.toCharArray()){
            contain[c - '0']++;
        }
        int A = 0;
        int B = 0;
        for(int i = 0; i < guess.length(); i++){
            char g = guess.charAt(i);
            if(contain[g - '0']>0){
                if(secret.charAt(i) == g){
                    A++;
                    contain[g - '0']--;
                    mark[i] = true;
                }
            }
        }
        for(int i = 0; i < guess.length(); i++){
            char g = guess.charAt(i);
            if((!mark[i]) && contain[g - '0']>0){
                B++;
                contain[g - '0']--;
            }
        }
        return A + "A" + B + "B";
    }
}
