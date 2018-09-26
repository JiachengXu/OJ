class Solution {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, -1, 0, 1};
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        Trie trie = new Trie();
        for(String word : words){
            trie.insert(word);
        }
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(board, i, j, trie.root, res);
            }
        }
        return res;
        
    }
    
    void dfs(char[][] board, int i, int j, Node node, List<String> res){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        char c = board[i][j];
        if(c == '#' || node.children[c - 'a'] == null) return;
        node = node.children[c - 'a'];
        if(node.word != null){
            res.add(node.word);
            node.word = null;
        }
        board[i][j] = '#';
        for(int k = 0; k < 4; k++){
            int ii = i + dx[k];
            int jj = j + dy[k];
            dfs(board, ii, jj, node, res);
        }
        board[i][j] = c;
    }
    
    class Trie{
        Node root;
        Trie(){
            root = new Node();
        }
        
        void insert(String word){
            Node cur = root;
            char[] cs = word.toCharArray();
            for(int i = 0; i < cs.length; i++){
                int idx = cs[i] - 'a';
                if(cur.children[idx] == null){
                    cur.children[idx] = new Node();
                }
                cur = cur.children[idx];
            }
            cur.word = word;
        }
    }
    
    class Node{
        String word;
        Node[] children = new Node[26];
    }
}
