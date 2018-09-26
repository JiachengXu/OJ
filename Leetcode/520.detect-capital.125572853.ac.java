class Solution {
    public boolean detectCapitalUse(String word) {
        if(word==null||word.length()==0) return false;
        int numCap = 0;
        boolean firstCap = false;
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)-'A'<=25&&'A'-word.charAt(i)<=0){
                if(i==0){
                    firstCap = true;
                }
                numCap++;
            }
        }
        return numCap==word.length()||(firstCap&&numCap==1)||numCap==0;
    }
}
