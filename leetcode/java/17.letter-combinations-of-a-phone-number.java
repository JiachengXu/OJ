class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> q = new LinkedList<>();
        if(digits.length()==0){
            return q;
        }
        String[] mapping = new String[]{"0","1","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        q.add("");
        for(int i = 0; i< digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(q.peek().length()==i){
                String t = q.remove();
                for(char s: mapping[x].toCharArray()){
                    q.add(t+s);
                }
            }
        }
        return q;
    }
}