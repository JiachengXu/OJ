class Solution {
    public boolean judgeCircle(String moves) {
        if(moves==null||moves.length()==0) return true;
        int right = 0;
        int left = 0;
        int up = 0;
        int down = 0;
        for(int i=0;i<moves.length();i++){
            char c = moves.charAt(i);
            if(c == 'R') right++;
            if(c == 'L') left++;
            if(c == 'U') up++;
            if(c == 'D') down++;
        }
        if((right==left)&&(up==down)) return true;
        return false;
    }
}