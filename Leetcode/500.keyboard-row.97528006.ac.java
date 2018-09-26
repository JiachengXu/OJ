public class Solution {
    public String[] findWords(String[] words) {
        String[] line ={"qwertyuiop","asdfghjkl","zxcvbnm"};
        ArrayList<String> solution = new ArrayList<>();
        int index1=0;
        int index2=0;
        int index3=0;
        for(String word:words){
            for(char c: word.toLowerCase().toCharArray()){
                if(line[0].indexOf(c)!=-1){
                    index1++;
                }
                if(line[1].indexOf(c)!=-1){
                    index2++;
                }                
                if(line[2].indexOf(c)!=-1){
                    index3++;
                }
            }
            if(index1==word.length()||index2==word.length()||index3==word.length()){
                solution.add(word);
            }
            index1=0;
            index2=0;
            index3=0;
        }
        return solution.toArray(new String[solution.size()]);
    }
}
