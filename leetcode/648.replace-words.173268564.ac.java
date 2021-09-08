class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        Node node = new Node();
        Node cur;
        for(String word: dict){
            cur = node;
            for(char c : word.toCharArray()){
                if(cur.children[c - 'a'] == null){
                    cur.children[c - 'a'] = new Node();
                }
                cur = cur.children[c - 'a'];
            }
            cur.isRoot = true;
        }
        
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");
        for(String word : words){
            System.out.println("word:" + word);
            cur = node;
            String temp = "";
            for(char c: word.toCharArray()){
                System.out.println(c);
                if(cur.children[c - 'a'] != null){
                    cur = cur.children[c - 'a'];
                    temp += String.valueOf(c);
                    if(cur.isRoot){
                        System.out.println("find root: " + temp);
                        break;
                    }
                }else{
                    temp = word;
                    break;
                }
            }
            sb.append(temp);
            sb.append(" ");
        }
        return sb.toString().trim();
        
    }
    class Node{
        boolean isRoot;
        Node[] children;
        Node(){
            children = new Node[26];
        }
    }
}
