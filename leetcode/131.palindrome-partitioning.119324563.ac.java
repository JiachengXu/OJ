class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        backtracking(res,temp,s,0);
        return res;
    }
    void backtracking(List<List<String>> res, List<String> temp, String s, int start){
        if(temp.size()>0&&start>=s.length()){
            res.add(new ArrayList<>(temp));
        }
        for(int i= start;i<s.length();i++){
            if(isPalindrome(s,start,i)){
                if(i==start){
                    temp.add(Character.toString(s.charAt(i)));
                }else{
                    temp.add(s.substring(start,i+1));
                }
                backtracking(res,temp,s,i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
    
    boolean isPalindrome(String str, int l, int r){
        if(l==r) return true;
        while(l<r){
            if(str.charAt(l)!=str.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
