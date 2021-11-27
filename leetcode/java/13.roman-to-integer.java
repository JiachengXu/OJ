class Solution {
    public int romanToInt(String s) {
        char[] cs = s.toCharArray();
        int res = 0;
        for(int i = 0; i < cs.length; i++){
            if(cs[i] == 'I'){
                if(i < cs.length - 1 && (cs[i+1] == 'V' || cs[i+1] == 'X')){
                    res -= 1;
                }else{
                    res += 1;
                }
            }else if(cs[i] == 'X'){
                if(i < cs.length - 1 && (cs[i+1] == 'L' || cs[i+1] == 'C')) {
                    res -= 10;
                }else{
                    res += 10;
                }
            }else if(cs[i] == 'C'){
                if(i < cs.length - 1 && (cs[i+1] == 'D' || cs[i+1] == 'M')){
                    res -= 100;
                }else{
                    res += 100;
                }
            }else if(cs[i] == 'V') res+= 5;
            else if(cs[i] == 'L') res += 50;
            else if(cs[i] == 'D') res += 500;
            else if(cs[i] == 'M') res += 1000;
        }
        return res;
    }
}