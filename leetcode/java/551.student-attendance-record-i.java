class Solution {
    public boolean checkRecord(String s) {
        int late = 0;
        int ab = 0;
        for(char c:s.toCharArray()){
            if(c=='A'){
                ab++;
                if(ab>=2){
                    return false;
                }
                late=0;
            }
            if(c=='P'){
                late=0;
            }
            if(c=='L'){
                late++;
                if(late>=3){
                    return false;
                }
            }
        }
        return true;
    }
}